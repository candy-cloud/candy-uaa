package com.fintech.uaa.dao.userinfo.impl;

import com.fintech.uaa.dao.userinfo.UserInfoDao;
import com.fintech.uaa.domain.RoleInfo;
import com.fintech.uaa.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("userInfoDao")
public class UserInfoDaoImpl implements UserInfoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String QUERY_USER_SQL = "select id,user_code as username ,user_password as password,user_real_name as realName ,user_phone as userPhone,tenant_id as tenantId ,list_user_type as userType from boss_user where user_code = ?";

    private static final String QUERY_ROLE_SQL = "select r.id,r.role_code,role_name from boss_user_role ur,boss_role r where ur.fk_role_id = r.id and fk_user_id = ? and r.tenant_id = ?";

    @Override
    public UserInfo findByUsername(String name) {

        List<UserInfo> userInfoList = jdbcTemplate.query(QUERY_USER_SQL, new String[]{name},new BeanPropertyRowMapper<UserInfo>(UserInfo.class));
        if (userInfoList == null || userInfoList.size() == 0) {
            throw new UsernameNotFoundException("没有找到用户");
        }

        if (userInfoList.size() > 1) {
            throw new UsernameNotFoundException("用户数据异常！");

        }
        //UserInfo userInfo = toUserInfo(userInfoList.get(0));
        UserInfo userInfo = userInfoList.get(0);
        String userId = userInfo.getId();
        String tenantId = userInfo.getTenantId();

        List<RoleInfo> roleInfoList = jdbcTemplate.query(QUERY_ROLE_SQL,new String[]{userId,tenantId}, new BeanPropertyRowMapper<RoleInfo>(RoleInfo.class));
        if (roleInfoList != null) {
            userInfo.setAuthorities(roleInfoList);
        }
        return userInfo;
    }

    private UserInfo toUserInfo(Map<String,Object> userInfoMap){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userInfoMap.get("id").toString());
        return userInfo;
    }
}

