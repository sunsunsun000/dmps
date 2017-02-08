package com.tanbobo.dmps.service.impl;

import com.tanbobo.dmps.mapper.SysResourceMapper;
import com.tanbobo.dmps.model.SysResource;
import com.tanbobo.dmps.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: SysResourceServiceImpl
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:37
 */
@Service("sysResourceService")
public class SysResourceServiceImpl implements SysResourceService {

    @Autowired
    private SysResourceMapper sysResourceMapper;

    @Override
    public List<SysResource> listAllResource() {
        return sysResourceMapper.selectAll();
    }

    @Override
    public SysResource findResourceById(Integer id) {
        return sysResourceMapper.findResourceById(id);
    }

    @Override
    public Integer saveResource(SysResource entity) {
        return sysResourceMapper.insert(entity);
    }

    @Override
    public Integer updateResource(SysResource entity) {
        return sysResourceMapper.updateByPrimaryKey(entity);
    }
}
