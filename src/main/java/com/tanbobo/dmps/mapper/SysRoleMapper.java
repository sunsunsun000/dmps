package com.tanbobo.dmps.mapper;

import com.tanbobo.dmps.base.BaseMapper;
import com.tanbobo.dmps.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: SysRoleMapper
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:30
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    List<SysRole> findAllSysRole();

    SysRole findRoleById(Integer id);

    List<SysRole> findRoleInRoleIds(@Param("rids") List<Integer> rids);
}
