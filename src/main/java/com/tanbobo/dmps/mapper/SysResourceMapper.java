package com.tanbobo.dmps.mapper;

import com.tanbobo.dmps.base.BaseMapper;
import com.tanbobo.dmps.model.SysResource;

import java.util.List;

/**
 * ClassName: SysResourceMapper
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:31
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {
    SysResource findResourceById(Integer id);

    List<SysResource> findByRoleId(Integer roleId);
}
