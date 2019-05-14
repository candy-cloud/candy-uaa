package com.fintech.uaa.domain;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;


/**
 * Created by fangzhipeng on 2017/5/27.
 */
public class RoleInfo implements GrantedAuthority, Serializable {

    /**
     * 角色id
     */
    private String id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


}
