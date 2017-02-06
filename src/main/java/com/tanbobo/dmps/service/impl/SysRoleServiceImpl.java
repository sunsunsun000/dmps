package com.tanbobo.dmps.service.impl;

import com.tanbobo.dmps.mapper.SysRoleMapper;
import com.tanbobo.dmps.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: SysRoleServiceImpl
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:35
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
}
