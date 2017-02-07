package com.tanbobo.dmps.model;

import com.tanbobo.dmps.base.BaseModel;

import java.util.Date;

/**
 * ClassName: SysUserRole
 * Author: tandingbo
 * CreateTime: 2017-02-07 14:25
 */
public class SysUserRole extends BaseModel {
    /**
     * 用户id
     */
    private Integer uid;
    /**
     * 角色id
     */
    private Integer roleId;
    /**
     * 创建时间
     */
    private Date createdTime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
