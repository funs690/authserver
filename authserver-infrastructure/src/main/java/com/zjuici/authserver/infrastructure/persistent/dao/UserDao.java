package com.zjuici.authserver.infrastructure.persistent.dao;


import com.zjuici.authserver.infrastructure.persistent.dos.UserDO;

public interface UserDao extends BaseDao<UserDO> {
    int deleteByPrimaryKey(String id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);
}