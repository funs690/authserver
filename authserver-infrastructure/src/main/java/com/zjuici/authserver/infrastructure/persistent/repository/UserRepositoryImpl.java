package com.zjuici.authserver.infrastructure.persistent.repository;

import com.zjuici.authserver.domain.entity.User;
import com.zjuici.authserver.domain.repository.UserRepository;
import com.zjuici.authserver.infrastructure.conveter.UserConveter;
import com.zjuici.authserver.infrastructure.persistent.dao.UserDao;
import com.zjuici.authserver.infrastructure.persistent.dao.UserInfoDao;
import com.zjuici.authserver.infrastructure.persistent.dos.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author fuzeqiang
 * @projectName authserver
 * @title: UserRepositoryImpl
 * @date 2021/12/30 17:43
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    /**
     * 用户dao
     */
    @Autowired
    private UserDao userDao;


    /**
     * 用户信息dao
     */
    @Autowired
    private UserInfoDao userInfoDao;


    /**
     * 获取用户信息
     *
     * @param username
     * @return
     */
    @Override
    public User findUser(String username) {
        UserDO userDO = new UserDO();
        userDO.setUsername(username);
        Optional<UserDO> userInfo = userDao.findOne(Example.of(userDO));
        return UserConveter.conveter(userInfo.get());
    }
}
