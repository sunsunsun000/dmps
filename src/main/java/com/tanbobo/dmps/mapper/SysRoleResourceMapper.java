package com.tanbobo.dmps.mapper;

import com.tanbobo.dmps.base.BaseMapper;
import com.tanbobo.dmps.model.SysRoleResource;

import java.util.List;

/**
 * ClassName: SysRoleResourceMapper
 * Author: tandingbo
 * CreateTime: 2017-02-08 15:24
 */
public interface SysRoleResourceMapper extends BaseMapper<SysRoleResource> {

    void deleteAllByRoleId(Integer roleId);

    List<Integer> findAllResourceByRoleId(Integer roleId);
}
