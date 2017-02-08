package com.tanbobo.dmps.service.impl;

import com.tanbobo.dmps.mapper.SysUserRoleMapper;
import com.tanbobo.dmps.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: SysUserRoleServiceImpl
 * Author: tandingbo
 * CreateTime: 2017-02-08 15:53
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Override
    public List<Integer> findRoleIdByUid(Integer uid) {
        return sysUserRoleMapper.findRoleIdByUid(uid);
    }
}
