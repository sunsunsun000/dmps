package com.tanbobo.dmps.model;

import com.tanbobo.dmps.base.BaseModel;

import java.util.Date;

/**
 * 用户登陆信息
 * ClassName: SysUser
 * Author: tandingbo
 * CreateTime: 2017-02-06 23:17
 */
public class SysUser extends BaseModel {
    /**
     * 登录名称
     */
    private String loginName;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 用户状态(1：有效 0：无效)
     */
    private Integer userStats;
    /**
     * 最后修改时间
     */
    private Date modifiedTime;

    public String getStatsText() {
        String text = "未知";
        if (userStats == 1) {
            text = "启用";
        } else if (userStats == 0) {
            text = "禁用";
        }
        return text;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserStats() {
        return userStats;
    }

    public void setUserStats(Integer userStats) {
        this.userStats = userStats;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
