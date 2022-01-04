package com.zjuici.authserver.infrastructure.persistent.dos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_user
 * @author 
 */
@Data
public class UserDO implements Serializable {

    /**
     * uuid
     */
    private static final long serialVersionUID = -7841883258790305780L;

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