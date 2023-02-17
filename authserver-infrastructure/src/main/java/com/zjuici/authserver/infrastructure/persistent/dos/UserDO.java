package com.zjuici.authserver.infrastructure.persistent.dos;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UserDO
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/17 16:00
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_user")
public class UserDO implements Serializable {

    /**
     * uuid
     */
    @Serial
    private static final long serialVersionUID = -1622765027199098469L;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
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
