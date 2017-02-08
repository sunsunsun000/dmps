package com.tanbobo.dmps.service;

import java.util.List;

/**
 * ClassName: SysUserRoleService
 * Author: tandingbo
 * CreateTime: 2017-02-08 15:53
 */
public interface SysUserRoleService {
    List<Integer> findRoleIdByUid(Integer uid);
}
