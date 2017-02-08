package com.tanbobo.dmps.mapper;

import com.tanbobo.dmps.base.BaseMapper;
import com.tanbobo.dmps.model.SysUser;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * ClassName: SysUserMapper
 * Author: tandingbo
 * CreateTime: 2017-02-06 23:30
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    public List<Map<String, Objects>> listMapAllUsers();

    public List<SysUser> listModelAll();

    SysUser findByName(String userName);

    SysUser getUserById(Integer id);
}
