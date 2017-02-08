package com.tanbobo.dmps.service;

import com.tanbobo.dmps.model.SysRoleResource;

import java.util.List;

/**
 * ClassName: SysRoleResourceService
 * Author: tandingbo
 * CreateTime: 2017-02-08 15:23
 */
public interface SysRoleResourceService {
    Integer saveBatchRoleResource(List<SysRoleResource> listEntity);

    List<Integer> findAllResourceByRoleId(Integer roleId);
}
