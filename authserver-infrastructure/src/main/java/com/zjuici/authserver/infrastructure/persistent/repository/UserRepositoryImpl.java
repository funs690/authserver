package com.zjuici.authserver.infrastructure.persistent.repository;

import com.zjuici.authserver.domain.entity.User;
import com.zjuici.authserver.domain.repository.UserRepository;
import com.zjuici.authserver.infrastructure.conveter.UserConveter;
import com.zjuici.authserver.infrastructure.persistent.condition.UserDOCondition;
import com.zjuici.authserver.infrastructure.persistent.dao.UserDao;
import com.zjuici.authserver.infrastructure.persistent.dao.UserInfoDao;
import com.zjuici.authserver.infrastructure.persistent.dos.UserDO;
import com.zjuici.authserver.infrastructure.util.CollectionUtil;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private UserDao userDao;


    /**
     * 用户信息dao
     */
    @Resource
    private UserInfoDao userInfoDao;


    /**
     * 获取用户信息
     *
     * @param username
     * @return
     */
    @Override
    public User findUser(String username) {
        UserDOCondition userDOCondition = UserDOCondition.builder().userName(username).build();
        List<UserDO> userDOList = userDao.getListByCondition(userDOCondition);
        if (CollectionUtil.isEmpty(userDOList)){
            return null;
        }
        return UserConveter.conveter(userDOList.get(0));
    }
}
