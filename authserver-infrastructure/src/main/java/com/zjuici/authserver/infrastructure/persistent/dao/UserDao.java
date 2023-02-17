package com.zjuici.authserver.infrastructure.persistent.dao;

import com.zjuici.authserver.infrastructure.persistent.dos.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author fuzeqiang
 * @Date 2023/2/17 16:06
 * @Version 1.0
 */
public interface UserDao extends JpaRepository<UserDO, String> {
}
