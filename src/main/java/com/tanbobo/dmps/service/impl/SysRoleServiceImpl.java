package com.tanbobo.dmps.service.impl;

import com.tanbobo.dmps.mapper.SysRoleMapper;
import com.tanbobo.dmps.model.SysRole;
import com.tanbobo.dmps.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: SysRoleServiceImpl
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:35
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public List<SysRole> listAllRoles() {
        return sysRoleMapper.selectAll();
    }

    @Override
    public SysRole findRoleById(Integer id) {
        return sysRoleMapper.findRoleById(id);
    }

    @Override
    public Integer saveRole(SysRole entity) {
        return sysRoleMapper.insert(entity);
    }

    @Override
    public Integer updateRole(SysRole entity) {
        return sysRoleMapper.updateByPrimaryKey(entity);
    }
}
