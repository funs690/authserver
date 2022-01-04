package com.zjuici.authserver.infrastructure.persistent.dao;


import com.zjuici.authserver.infrastructure.persistent.dos.UserInfoDO;

public interface UserInfoDao extends BaseDao<UserInfoDO> {
    int deleteByPrimaryKey(String id);

    int insert(UserInfoDO record);

    int insertSelective(UserInfoDO record);

    UserInfoDO selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserInfoDO record);

    int updateByPrimaryKey(UserInfoDO record);
}