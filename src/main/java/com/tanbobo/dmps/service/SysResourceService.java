package com.tanbobo.dmps.service;

import com.tanbobo.dmps.model.SysResource;

import java.util.List;

/**
 * ClassName: SysResourceService
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:35
 */
public interface SysResourceService {
    List<SysResource> listAllResource();

    SysResource findResourceById(Integer id);

    Integer saveResource(SysResource entity);

    Integer updateResource(SysResource entity);
}
