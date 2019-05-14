package com.fintech.uaa.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
 * Created by fangzhipeng on 2017/5/27.
 */

public class UserInfo implements UserDetails, Serializable {

    /**
     * 用户id
     */
    private String id;

    /**
     * 这里的用户名称对应在系统中的usercode
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户真实名称
     */
    private String realName;

    /**
     * 用户手机号
     */
    private String userPhone;

    /**
     * 租户id
     */
    private String tenantId;

    /**
     * 1:租户2.用户
     */
    private String userType;


    /**
     * 用户角色
     */
    private List<RoleInfo> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<RoleInfo> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 用户的帐户是否已过期。过期的帐户不能验证
     *
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指示用户是锁定还是解锁
     *
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示用户的凭据（密码）是否已过期。期满凭据阻止身份验证。
     *
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 指示用户是启用还是禁用。禁用的用户不能验证。
     *
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    /**
     * 用户id
     *
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
