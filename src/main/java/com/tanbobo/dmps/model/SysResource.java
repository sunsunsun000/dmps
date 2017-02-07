package com.tanbobo.dmps.model;

import com.tanbobo.dmps.base.BaseModel;

import java.util.Date;

/**
 * ClassName: SysResourceMapper
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:29
 */
public class SysResource extends BaseModel {
    /**
     * 权限名称
     */
    private String name;
    /**
     * 访问地址
     */
    private String urls;
    /**
     * 状态(1：有效 0：无效)
     */
    private Integer resourceStats;
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

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public Integer getResourceStats() {
        return resourceStats;
    }

    public void setResourceStats(Integer resourceStats) {
        this.resourceStats = resourceStats;
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
