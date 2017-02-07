package com.tanbobo.dmps.model;

import com.tanbobo.dmps.base.BaseModel;

import java.util.Date;

/**
 * ClassName: SysRole
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:29
 */
public class SysRole extends BaseModel {
    /**
     * 角色名称
     */
    private String name;
    /**
     * 状态(1：有效 0：无效)
     */
    private Integer roleStats;
    /**
     * 创建时间
     */
    private Date createdTime;
    /**
     * 最后一次更新时间
     */
    private Date modifiedTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRoleStats() {
        return roleStats;
    }

    public void setRoleStats(Integer roleStats) {
        this.roleStats = roleStats;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
