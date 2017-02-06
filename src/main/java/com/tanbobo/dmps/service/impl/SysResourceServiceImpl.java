package com.tanbobo.dmps.service.impl;

import com.tanbobo.dmps.mapper.SysResourceMapper;
import com.tanbobo.dmps.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: SysResourceServiceImpl
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:37
 */
@Service("sysResourceService")
public class SysResourceServiceImpl implements SysResourceService {

    @Autowired
    private SysResourceMapper sysResourceMapper;
}
