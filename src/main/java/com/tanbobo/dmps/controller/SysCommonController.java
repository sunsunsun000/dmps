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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {
        return "admin/common/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "admin/common/login";
    }
}
