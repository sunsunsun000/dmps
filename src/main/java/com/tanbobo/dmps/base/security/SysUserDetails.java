package com.tanbobo.dmps.base.security;

import com.tanbobo.dmps.model.SysRole;
import com.tanbobo.dmps.model.SysUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * ClassName: SysUserDetails
 * Author: tandingbo
 * CreateTime: 2017-02-08 17:53
 */
public class SysUserDetails extends SysUser implements UserDetails {

    private List<SysRole> roles;

    public SysUserDetails(SysUser sysUser, List<SysRole> roles) {
        super(sysUser);
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (roles != null && roles.size() > 0) {
            for (SysRole role : roles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public String getUsername() {
        return super.getLoginName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
