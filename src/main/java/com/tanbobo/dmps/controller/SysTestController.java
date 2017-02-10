package com.tanbobo.dmps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: SysTestController
 * Author: tandingbo
 * CreateTime: 2017-02-11 00:46
 */
@Controller
@RequestMapping("/test")
public class SysTestController {

    @RequestMapping(value = "/page1", method = RequestMethod.GET)
    public String page1() {
        return "admin/test/page1";
    }

    @RequestMapping(value = "/page2", method = RequestMethod.GET)
    public String page2() {
        return "admin/test/page2";
    }

    @RequestMapping(value = "/page3", method = RequestMethod.GET)
    public String page3() {
        return "admin/test/page3";
    }

    @RequestMapping(value = "/page4", method = RequestMethod.GET)
    public String page4() {
        return "admin/test/page4";
    }

    @RequestMapping(value = "/page5", method = RequestMethod.GET)
    public String page5() {
        return "admin/test/page5";
    }

}
