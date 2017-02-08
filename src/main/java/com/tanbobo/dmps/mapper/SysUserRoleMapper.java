package com.tanbobo.dmps.mapper;

import com.tanbobo.dmps.base.BaseMapper;
import com.tanbobo.dmps.model.SysUserRole;

import java.util.List;

/**
 * ClassName: SysUserRoleMapper
 * Author: tandingbo
 * CreateTime: 2017-02-08 15:54
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    List<Integer> findRoleIdByUid(Integer uid);

    void deleteAllByUid(Integer uid);
}
