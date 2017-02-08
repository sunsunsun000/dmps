package com.tanbobo.dmps.service;

import com.tanbobo.dmps.model.SysRole;

import java.util.List;

/**
 * ClassName: SysRoleService
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:35
 */
public interface SysRoleService {
    List<SysRole> listAllRoles();

    SysRole findRoleById(Integer id);

    Integer saveRole(SysRole entity);

    Integer updateRole(SysRole entity);
}
