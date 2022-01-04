package com.zjuici.authserver.domain.repository;

import com.zjuici.authserver.domain.entity.User;

/**
 * @author fuzeqiang
 * @projectName authserver
 * @title: UserRepository
 * @date 2021/12/30 17:39
 */
public interface UserRepository {

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    User findUser(String username);
}
