package com.tanbobo.dmps.service.impl;

import com.tanbobo.dmps.mapper.SysRoleResourceMapper;
import com.tanbobo.dmps.model.SysRoleResource;
import com.tanbobo.dmps.service.SysRoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: SysRoleResourceServiceImpl
 * Author: tandingbo
 * CreateTime: 2017-02-08 15:24
 */
@Service("sysRoleResourceService")
public class SysRoleResourceServiceImpl implements SysRoleResourceService {

    @Autowired
    private SysRoleResourceMapper sysRoleResourceMapper;

    @Override
    public Integer saveBatchRoleResource(List<SysRoleResource> listEntity) {
        sysRoleResourceMapper.deleteAllByRoleId(listEntity.get(0).getRoleId());
        return sysRoleResourceMapper.insertList(listEntity);
    }

    @Override
    public List<Integer> findAllResourceByRoleId(Integer roleId) {
        return sysRoleResourceMapper.findAllResourceByRoleId(roleId);
    }
}
