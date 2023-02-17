package com.zjuici.authserver.infrastructure.persistent.dos;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UserInfoDO
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/17 16:00
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "tb_user_info")
public class UserInfoDO implements Serializable {

    /**
     * uuid
     */
    @Serial
    private static final long serialVersionUID = 5424123422845001777L;

    /**
     * id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String id;

    /**
     * 用户id
     */
    private String userId;

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
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
