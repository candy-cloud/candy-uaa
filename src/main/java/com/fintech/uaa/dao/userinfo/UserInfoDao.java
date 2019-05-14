package com.fintech.uaa.dao.userinfo;

import com.fintech.uaa.domain.UserInfo;
import org.springframework.stereotype.Component;

public interface UserInfoDao {

    public UserInfo findByUsername(String name);

}
