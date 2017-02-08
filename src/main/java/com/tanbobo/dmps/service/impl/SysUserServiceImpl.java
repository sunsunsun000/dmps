package com.tanbobo.dmps.service.impl;

import com.tanbobo.dmps.mapper.SysUserMapper;
import com.tanbobo.dmps.model.SysUser;
import com.tanbobo.dmps.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * ClassName: SysUserServiceImpl
 * Author: tandingbo
 * CreateTime: 2017-02-06 23:32
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    /**
     * 获取所有登录用户信息
     *
     * @return
     */
    @Override
    public List<Map<String, Objects>> listMapAllUsers() {
        return sysUserMapper.listMapAllUsers();
    }

    /**
     * 获取所有登录用户信息
     *
     * @return
     */
    @Override
    public List<SysUser> listModelAll() {
        return sysUserMapper.listModelAll();
    }

    @Override
    public SysUser getUserById(Integer id) {
        return sysUserMapper.getUserById(id);
    }

    @Override
    public void saveUser(SysUser entity) {
        sysUserMapper.insert(entity);
    }

    @Override
    public void updateUser(SysUser entity) {
        sysUserMapper.updateByPrimaryKey(entity);
    }

}
