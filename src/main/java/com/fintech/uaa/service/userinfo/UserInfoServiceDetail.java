package com.fintech.uaa.service.userinfo;

import com.fintech.uaa.dao.userinfo.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceDetail implements UserDetailsService {

    @Autowired
    @Qualifier("userInfoDao")
    private UserInfoDao userInfoDao;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        try {
            return userInfoDao.findByUsername(name);
        } catch (UsernameNotFoundException e) {
            throw e;
        }
    }

}
