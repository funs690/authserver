package com.zjuici.authserver.infrastructure.persistent.dao;

import com.zjuici.authserver.infrastructure.persistent.dos.UserInfoDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserInfoDao
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/17 16:07
 * @Version 1.0
 */
public interface UserInfoDao extends JpaRepository<UserInfoDO, String> {
}
