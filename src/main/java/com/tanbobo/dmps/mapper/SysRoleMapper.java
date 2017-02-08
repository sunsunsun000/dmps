package com.tanbobo.dmps.mapper;

import com.tanbobo.dmps.base.BaseMapper;
import com.tanbobo.dmps.model.SysRole;

/**
 * ClassName: SysRoleMapper
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:30
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    SysRole findRoleById(Integer id);
}
