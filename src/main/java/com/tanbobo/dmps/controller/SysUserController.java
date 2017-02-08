package com.tanbobo.dmps.controller;

import com.tanbobo.dmps.model.SysRole;
import com.tanbobo.dmps.model.SysUser;
import com.tanbobo.dmps.model.SysUserRole;
import com.tanbobo.dmps.service.SysRoleService;
import com.tanbobo.dmps.service.SysUserRoleService;
import com.tanbobo.dmps.service.SysUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ClassName: SysUserController
 * Author: tandingbo
 * CreateTime: 2017-02-06 23:33
 */
@Controller
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserRoleService sysUserRoleService;

    /**
     * 列表登录用户信息
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listAllUsers(Model model) {
        List<SysUser> listModelUser = sysUserService.listModelAll();
        model.addAttribute("listUser", listModelUser);
        return "user/index";
    }

    /**
     * 添加登录用户信息
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addUser(Model model) {
        SysUser sysUser = new SysUser();
        model.addAttribute("user", sysUser);

        List<Integer> listRoleId = new ArrayList<>();
        model.addAttribute("listRoleId", listRoleId);

        List<SysRole> listRoles = getListRoles();
        model.addAttribute("listRoles", listRoles);
        return "user/edit";
    }

    /**
     * 修改登录用户信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editUser(@PathVariable Integer id, Model model) {
        SysUser sysUser = sysUserService.getUserById(id);
        model.addAttribute("user", sysUser);

        List<Integer> listRoleId = sysUserRoleService.findRoleIdByUid(id);
        model.addAttribute("listRoleId", listRoleId);

        List<SysRole> listRoles = getListRoles();
        model.addAttribute("listRoles", listRoles);
        return "user/edit";
    }

    /**
     * 保存登录用户信息
     *
     * @param id
     * @param username
     * @param password
     * @param stats
     * @param model
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@RequestParam(value = "id", required = false) Integer id,
                           @RequestParam(value = "username", required = false) String username,
                           @RequestParam(value = "password", required = false) String password,
                           @RequestParam(value = "role_ids[]", required = false) List<Integer> roleIds,
                           @RequestParam(value = "stats") Integer stats, Model model) {

        SysUser sysUser = new SysUser();

        List<SysUserRole> listUserRole = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(roleIds)) {
            Date now = new Date();
            for (Integer roleId : roleIds) {
                SysUserRole userRole = new SysUserRole();
                userRole.setUid(id);
                userRole.setRoleId(roleId);
                userRole.setCreatedTime(now);
                listUserRole.add(userRole);
            }
        }

        if (null != id) {
            try {
                sysUser = sysUserService.getUserById(id);
                sysUser.setUserStats(stats);
                sysUserService.updateUser(listUserRole, sysUser);
            } catch (Exception e) {
                model.addAttribute("msg", "操作失败！");
            }
        } else {
            try {
                if (StringUtils.isBlank(username)) {
                    throw new RuntimeException("登录名称不能为空！");
                }
                sysUser.setLoginName(username);
                if (StringUtils.isBlank(password)) {
                    throw new RuntimeException("登录密码不能为空！");
                }
                sysUser.setPassword(password);
                sysUser.setUserStats(stats);
                sysUserService.saveUser(listUserRole, sysUser);
            } catch (RuntimeException e) {
                model.addAttribute("msg", e.getMessage());
            } catch (Exception e) {
                model.addAttribute("msg", "操作失败！");
            }
        }

        List<SysRole> listRoles = getListRoles();
        model.addAttribute("listRoles", listRoles);

        List<Integer> listRoleId = sysUserRoleService.findRoleIdByUid(id);
        model.addAttribute("listRoleId", listRoleId);

        model.addAttribute("user", sysUser);
        return "user/edit";
    }

    /**
     * 获取所有的角色
     *
     * @return
     */
    public List<SysRole> getListRoles() {
        List<SysRole> roles = sysRoleService.listAllRoles();
        return roles;
    }
}
