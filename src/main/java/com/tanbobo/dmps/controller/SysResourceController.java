package com.tanbobo.dmps.controller;

import com.tanbobo.dmps.model.SysResource;
import com.tanbobo.dmps.service.SysResourceService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * ClassName: SysResourceController
 * Author: tandingbo
 * CreateTime: 2017-02-07 00:40
 */
@Controller
@RequestMapping("/access")
public class SysResourceController {

    @Autowired
    private SysResourceService sysResourceService;

    /**
     * 列表
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listAllResource(Model model) {
        List<SysResource> listResource = sysResourceService.listAllResource();
        model.addAttribute("listResource", listResource);
        return "access/index";
    }

    /**
     * 新增
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addResource(Model model) {
        SysResource resource = new SysResource();
        model.addAttribute("access", resource);
        model.addAttribute("title", "新增权限");
        return "access/edit";
    }

    /**
     * 修改
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editResource(@PathVariable("id") Integer id, Model model) {
        SysResource sysResource = sysResourceService.findResourceById(id);
        model.addAttribute("access", sysResource);
        model.addAttribute("title", "编辑权限");
        return "access/edit";
    }

    /**
     * 保存
     *
     * @param id
     * @param name
     * @param urls
     * @param model
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveResource(@RequestParam(value = "id", required = false) Integer id,
                               @RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "urls", required = false) String urls,
                               Model model) {

        SysResource sysResource = new SysResource();
        if (null == id) {
            try {
                if (StringUtils.isBlank(name)) {
                    throw new RuntimeException("请输入权限名称！");
                }
                sysResource.setName(name);
                if (StringUtils.isBlank(urls)) {
                    throw new RuntimeException("请输入权限URL地址！");
                }
                sysResource.setUrls(urls);
                sysResource.setCreatedTime(new Date());
                sysResource.setResourceStats(1);
                sysResourceService.saveResource(sysResource);
            } catch (RuntimeException e) {
                model.addAttribute("msg", e.getMessage());
            } catch (Exception e) {
                model.addAttribute("msg", "操作失败！");
            }
        } else {
            try {
                sysResource = sysResourceService.findResourceById(id);
                if (StringUtils.isNoneBlank(name)) {
                    sysResource.setName(name);
                }
                if (StringUtils.isNoneBlank(urls)) {
                    sysResource.setUrls(urls);
                }
                sysResourceService.updateResource(sysResource);
            } catch (Exception e) {
                model.addAttribute("msg", "操作失败！");
            }
        }

        model.addAttribute("access", sysResource);
        return "access/edit";
    }
}
