package com.zjuici.authserver.infrastructure.conveter;

import com.zjuici.authserver.domain.entity.User;
import com.zjuici.authserver.infrastructure.persistent.dos.UserDO;
import org.springframework.beans.BeanUtils;

/**
 * @author fuzeqiang
 * @projectName authserver
 * @title: UserConveter
 * @date 2021/12/30 18:00
 */
public class UserConveter {


    /**
     *数据转化为user
     * @param userDO
     * @return
     */
    public static User conveter(UserDO userDO) {
        User user = new User();
        BeanUtils.copyProperties(userDO, user);
        return user;
    }
}
