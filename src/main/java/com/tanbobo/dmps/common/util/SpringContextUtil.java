package com.tanbobo.dmps.common.util;

import org.springframework.context.ApplicationContext;

/**
 * ClassName: SpringContextUtil
 * Author: tandingbo
 * CreateTime: 2017-02-07 21:34
 */
public class SpringContextUtil {
    private static ApplicationContext applicationContext;

    //获取上下文
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //设置上下文
    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }

    //通过名字获取上下文中的bean
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    //通过类型获取上下文中的bean
    public static Object getBean(Class<?> requiredType) {
        return applicationContext.getBean(requiredType);
    }
}
