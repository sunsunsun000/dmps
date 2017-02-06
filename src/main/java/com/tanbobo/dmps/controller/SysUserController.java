package com.tanbobo.dmps.controller;

import com.alibaba.fastjson.JSON;
import com.tanbobo.dmps.model.SysUser;
import com.tanbobo.dmps.service.SysUserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * ClassName: SysUserController
 * Author: tandingbo
 * CreateTime: 2017-02-06 23:33
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping
    @ResponseBody
    public String listMapAllUsers() {
        List<SysUser> listAllUser = sysUserService.listModelAll();
        if (CollectionUtils.isNotEmpty(listAllUser)) {
            for (SysUser s : listAllUser) {
                System.out.println(s.getLoginName());
            }
        }

        List<Map<String, Objects>> listMapUser = sysUserService.listMapAllUsers();
        return JSON.toJSONString(listMapUser);
    }
}
