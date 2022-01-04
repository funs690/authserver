package com.zjuici.authserver.infrastructure.persistent.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author fuzeqiang
 * @version 1.0
 * @date 2021/4/1 15:52
 */
@Data
@SuperBuilder
@AllArgsConstructor
public class UserDOCondition extends PageCondition {

    /**
     * 唯一键
     */
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String passWord;

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



}
