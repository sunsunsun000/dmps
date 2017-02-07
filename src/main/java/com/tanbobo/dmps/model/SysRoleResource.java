package com.tanbobo.dmps.model;

import com.tanbobo.dmps.base.BaseModel;

import java.util.Date;

/**
 * ClassName: SysRoleResource
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:30
 */
public class SysRoleResource extends BaseModel {
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 权限资源id
     */
    private Integer resourceId;
    /**
     * 创建时间
     */
    private Date createdTime;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
