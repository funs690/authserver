package com.zjuici.authserver.application.service.biz.user.impl;

import com.zjuici.authserver.domain.entity.User;
import com.zjuici.authserver.domain.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fuzeqiang
 * @projectName authserver
 * @title: UserDetailsServiceImpl
 * @date 2021/12/30 17:47
 */
@Log4j2
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    /**
     * 用户信息服务类
     */
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUser(username);
        if (user == null){
            throw new UsernameNotFoundException("user not exists !");
        }
        //根据用id获取当前用户的角色信息
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities);
    }
}
