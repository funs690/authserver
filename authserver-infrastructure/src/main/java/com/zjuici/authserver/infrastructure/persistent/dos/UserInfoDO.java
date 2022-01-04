package com.zjuici.authserver.infrastructure.persistent.dos;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * tb_user_info
 * @author 
 */
@Data
public class UserInfoDO implements Serializable {

    /**
     * uuid
     */
    private static final long serialVersionUID = -645017580819661608L;

    /**
     * 唯一键
     */
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