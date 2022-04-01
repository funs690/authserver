--先删除库
drop database if exists authserverdb;
drop user if exists authserver;

--创建数据库
create database authserverdb;
--创建用户名称
create user authserver with password 'Abc123++';

--更换数据库所有者
alter database authserverdb owner to authserver;


--切换数据库
\connect authserverdb

--设置编码格式
set client_encoding to 'UTF-8';

--创建uuid扩展
create extension "uuid-ossp";


/**
 * 创建uuid方法
 */
create or replace function uuid_generate()
returns varchar as $$
declare
uuid_string varchar;
begin
	/** get uuid info **/
select uuid_generate_v4() into uuid_string;
/** replace all - in uuid info**/
uuid_string := replace(uuid_string, '-', '');
return uuid_string;
end;
$$ language plpgsql;


--表数初始化
drop table if exists oauth2_authorization;
drop table if exists oauth2_authorization_consent;
drop table if exists oauth2_registered_client;
drop table if exists tb_user;
drop table if exists tb_user_info;

--授权服务信息表
create table oauth2_authorization (
    id varchar(100) not null,
    registered_client_id varchar(100) not null,
    principal_name varchar(200) not null,
    authorization_grant_type varchar(100) not null,
    attributes text default null,
    state varchar(500) default null,
    authorization_code_value text default null,
    authorization_code_issued_at timestamp default null,
    authorization_code_expires_at timestamp default null,
    authorization_code_metadata text default null,
    access_token_value text default null,
    access_token_issued_at timestamp default null,
    access_token_expires_at timestamp default null,
    access_token_metadata text default null,
    access_token_type varchar(100) default null,
    access_token_scopes varchar(1000) default null,
    oidc_id_token_value text default null,
    oidc_id_token_issued_at timestamp default null,
    oidc_id_token_expires_at timestamp default null,
    oidc_id_token_metadata text default null,
    refresh_token_value text default null,
    refresh_token_issued_at timestamp default null,
    refresh_token_expires_at timestamp default null,
    refresh_token_metadata text default null,
    primary key (id)
);
alter table oauth2_authorization owner to authserver;

--授权服务信息表
create table oauth2_authorization_consent (
    registered_client_id varchar(100) not null,
    principal_name varchar(200) not null,
    authorities varchar(1000) not null,
    primary key (registered_client_id, principal_name)
);
alter table oauth2_authorization_consent owner to authserver;

-- register client
create table oauth2_registered_client (
    id varchar(100) not null,
    client_id varchar(100) not null,
    client_id_issued_at timestamp default current_timestamp not null,
    client_secret varchar(200) default null,
    client_secret_expires_at timestamp default null,
    client_name varchar(200) not null,
    client_authentication_methods varchar(1000) not null,
    authorization_grant_types varchar(1000) not null,
    redirect_uris varchar(1000) default null,
    scopes varchar(1000) not null,
    client_settings varchar(2000) not null,
    token_settings varchar(2000) not null,
    primary key (id)
);
alter table oauth2_registered_client owner to authserver;

--创建用户信息表
create table tb_user(
    id varchar(64) primary key default uuid_generate(),
    username varchar(64) not null,
    password varchar(128),
    on_line integer default 0,
    ip_address varchar(64),
    is_lock	integer default 0,
    is_delete integer default 0,
    create_time timestamp without time zone,
    update_time timestamp without time zone
);
comment on table tb_user is '用户信息表';
comment on column tb_user.id is '唯一键';
comment on column tb_user.username is '用户名';
comment on column tb_user.password is '密码';
comment on column tb_user.on_line is '是否在线,0：不在线;1：在线';
comment on column tb_user.ip_address is 'ip地址';
comment on column tb_user.is_lock is '账户锁定，0：未锁定;1：锁定';
comment on column tb_user.is_delete is '是否删除表示位置,0：正常使用;1：已删除';
comment on column tb_user.create_time is '创建时间';
comment on column tb_user.update_time is '更新时间';
create index idx_tb_user_username on tb_user(username);
alter table tb_user owner to authserver;


--用户信息表
create table tb_user_info(
    id varchar(64) primary key default uuid_generate(),
    user_id varchar(64) not null,
    name varchar(64),
    phone varchar(64),
    email varchar(64),
    address varchar(128),
    description varchar(128),
    create_time timestamp without time zone,
    update_time timestamp without time zone
);
comment on table tb_user_info is '用户信息详情表';
comment on column tb_user_info.id is '唯一键';
comment on column tb_user_info.user_id is '用户id';
comment on column tb_user_info.name is '姓名';
comment on column tb_user_info.phone is '手机号码';
comment on column tb_user_info.email is '邮箱地址';
comment on column tb_user_info.address is '地址信息';
comment on column tb_user_info.description is '描述信息';
comment on column tb_user_info.create_time is '创建时间';
comment on column tb_user_info.update_time is '更新时间';
alter table tb_user_info owner to authserver;

-- 初始化超级管理员用户
insert into tb_user (username, password, on_line, is_lock, is_delete, create_time, update_time) values
    ('admin', '$2a$10$hb7J3dC9Nzh6zXqTgEVglOcLeTXWM9Fmz5XBCEsmQbeZYAjqexLwa', 0, 0, 0, now(), now());
