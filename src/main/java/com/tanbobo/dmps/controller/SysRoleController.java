package com.tanbobo.dmps.controller;

import com.tanbobo.dmps.model.SysResource;
import com.tanbobo.dmps.model.SysRole;
import com.tanbobo.dmps.model.SysRoleResource;
import com.tanbobo.dmps.service.SysResourceService;
import com.tanbobo.dmps.service.SysRoleResourceService;
import com.tanbobo.dmps.service.SysRoleService;
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
 * ClassName: SysRoleController
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:39
 */
@Controller
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysResourceService sysResourceService;
    @Autowired
    private SysRoleResourceService sysRoleResourceService;

    /**
     * 角色信息列表
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listRoles(Model model) {
        List<SysRole> listRole = sysRoleService.listAllRoles();
        model.addAttribute("listRole", listRole);
        return "role/index";
    }

    /**
     * 添加角色信息
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addRole(Model model) {
        SysRole sysRole = new SysRole();
        model.addAttribute("role", sysRole);
        model.addAttribute("title", "添加角色");
        return "role/edit";
    }

    /**
     * 修改角色信息
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editRole(@PathVariable("id") Integer id, Model model) {
        SysRole sysRole = sysRoleService.findRoleById(id);
        model.addAttribute("role", sysRole);
        model.addAttribute("title", "编辑角色");
        return "role/edit";
    }

    /**
     * 设置权限
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}/access", method = RequestMethod.GET)
    public String access(@PathVariable("id") Integer id, Model model) {
        SysRole sysRole = sysRoleService.findRoleById(id);
        model.addAttribute("role", sysRole);

        List<Integer> listResourceId = sysRoleResourceService.findAllResourceByRoleId(id);
        model.addAttribute("resourceIds", listResourceId);

        List<SysResource> listResources = listAllResource();
        model.addAttribute("listResources", listResources);
        return "role/access";
    }

    @RequestMapping(value = "/access", method = RequestMethod.POST)
    public String saveAccess(@RequestParam("id") Integer id,
                             @RequestParam("access_ids[]") List<Integer> accessIds,
                             Model model) {

        SysRole sysRole = sysRoleService.findRoleById(id);
        try {
            if (null != sysRole && CollectionUtils.isNotEmpty(accessIds)) {
                List<SysRoleResource> listRoleResource = new ArrayList<>();
                for (Integer accessId : accessIds) {
                    SysRoleResource roleResource = new SysRoleResource();
                    roleResource.setRoleId(id);
                    roleResource.setResourceId(accessId);
                    listRoleResource.add(roleResource);
                }

                sysRoleResourceService.saveBatchRoleResource(listRoleResource);
            }

            List<SysRole> listRole = sysRoleService.listAllRoles();
            model.addAttribute("listRole", listRole);

            return "role/index";
        } catch (Exception e) {
            List<SysResource> listResources = listAllResource();
            model.addAttribute("listResources", listResources);

            model.addAttribute("role", sysRole);
            model.addAttribute("msg", "操作失败！");

            e.printStackTrace();
            return "role/access";
        }
    }

    /**
     * 保存角色信息
     *
     * @param roleNmae
     * @param stats
     * @param model
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRole(@RequestParam(value = "id", required = false) Integer id,
                           @RequestParam(value = "roleName", required = false) String roleNmae,
                           @RequestParam(value = "stats", required = false) Integer stats, Model model) {

        SysRole sysRole = new SysRole();
        if (null != id) {
            try {
                sysRole = sysRoleService.findRoleById(id);
                if (StringUtils.isNoneBlank(roleNmae)) {
                    sysRole.setName(roleNmae);
                }
                if (null != stats) {
                    sysRole.setRoleStats(stats);
                }

                sysRoleService.updateRole(sysRole);
            } catch (Exception e) {
                model.addAttribute("msg", "操作失败！");
            }
        } else {
            try {
                if (StringUtils.isBlank(roleNmae)) {
                    throw new RuntimeException("角色名称不能为空！");
                }
                sysRole.setName(roleNmae);
                if (null == stats) {
                    throw new RuntimeException("请选择角色状态！");
                }
                sysRole.setRoleStats(stats);
                sysRole.setCreatedTime(new Date());

                sysRoleService.saveRole(sysRole);
            } catch (RuntimeException e) {
                model.addAttribute("msg", e.getMessage());
            } catch (Exception e) {
                model.addAttribute("msg", "操作失败！");
            }
        }

        model.addAttribute("role", sysRole);
        return "role/edit";
    }

    /**
     * 获取所有资源信息
     *
     * @return
     */
    private List<SysResource> listAllResource() {
        List<SysResource> listAllResource = sysResourceService.listAllResource();
        return listAllResource;
    }
}

