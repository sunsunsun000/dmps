package com.tanbobo.dmps.base.security;

import com.tanbobo.dmps.mapper.SysRoleMapper;
import com.tanbobo.dmps.mapper.SysUserMapper;
import com.tanbobo.dmps.mapper.SysUserRoleMapper;
import com.tanbobo.dmps.model.SysRole;
import com.tanbobo.dmps.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * ClassName: SysUserDetailsService
 * Author: tandingbo
 * CreateTime: 2017-02-10 23:20
 */
@Component
public class SysUserDetailsService implements UserDetailsService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SysUser user;
        try {
            user = sysUserMapper.findByName(userName);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user select fail");
        }
        if (user == null) {
            throw new UsernameNotFoundException("no user found");
        } else {
            try {
                List<Integer> rids = sysUserRoleMapper.findRoleIdByUid(user.getId());
                List<SysRole> roles = sysRoleMapper.findRoleInRoleIds(rids);
                return new SysUserDetails(user, roles);
            } catch (Exception e) {
                throw new UsernameNotFoundException("user role select fail");
            }
        }
    }
}
