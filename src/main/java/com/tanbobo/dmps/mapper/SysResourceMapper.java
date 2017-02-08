package com.tanbobo.dmps.mapper;

import com.tanbobo.dmps.base.BaseMapper;
import com.tanbobo.dmps.model.SysResource;

/**
 * ClassName: SysResourceMapper
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:31
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {
    SysResource findResourceById(Integer id);
}
