package com.tanbobo.dmps.service.impl;

import com.tanbobo.dmps.service.SysRoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: SysRoleResourceServiceImpl
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:38
 */
@Service("sysRoleResourceService")
public class SysRoleResourceServiceImpl implements SysRoleResourceService {

    @Autowired
    private SysRoleResourceMapper sysRoleResourceMapper;
}
