package com.tanbobo.dmps.service;

import com.tanbobo.dmps.model.SysUser;
import com.tanbobo.dmps.model.SysUserRole;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * ClassName: SysUserService
 * Author: tandingbo
 * CreateTime: 2017-02-06 23:32
 */
public interface SysUserService {
    /**
     * 获取所有登录用户信息
     *
     * @return
     */
    public List<Map<String, Objects>> listMapAllUsers();

    /**
     * 获取所有登录用户信息
     *
     * @return
     */
    public List<SysUser> listModelAll();

    SysUser getUserById(Integer id);

    void saveUser(List<SysUserRole> listUserRole, SysUser entity);

    void updateUser(List<SysUserRole> listUserRole, SysUser entity);
}
