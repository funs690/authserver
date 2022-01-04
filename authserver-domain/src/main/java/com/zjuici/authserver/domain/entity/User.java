package com.zjuici.authserver.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author fuzeqiang
 * @projectName authserver
 * @title: User
 * @date 2021/12/30 17:40
 */
@Data
public class User {
    /**
     * 唯一键
     */
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;


    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 地址信息
     */
    private String address;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 是否在线,0：不在线;1：在线
     */
    private Integer onLine;

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * 账户锁定，0：未锁定;1：锁定
     */
    private Integer isLock;

    /**
     * 是否删除表示位置,0：正常使用;1：已删除
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
