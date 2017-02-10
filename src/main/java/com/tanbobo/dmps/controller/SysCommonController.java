package com.tanbobo.dmps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: SysCommonController
 * Author: tandingbo
 * CreateTime: 2017-02-08 16:26
 */
@Controller
public class SysCommonController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "admin/common/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "admin/common/login";
    }

    @RequestMapping("/400")
    public String page400() {
        return "admin/common/400";
    }

    @RequestMapping("/403")
    public String page403() {
        return "admin/common/403";
    }

    @RequestMapping("/404")
    public String page404() {
        return "admin/common/404";
    }

    @RequestMapping("/500")
    public String page500() {
        return "admin/common/500";
    }

    @RequestMapping("/exception")
    public String catchException() {
        return "admin/common/error";
    }
}
