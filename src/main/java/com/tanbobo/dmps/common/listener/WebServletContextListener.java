package com.tanbobo.dmps.common.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ClassName: WebServletContextListener
 * Author: tandingbo
 * CreateTime: 2017-02-07 22:08
 */
public class WebServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("context", servletContext.getContextPath());
        servletContext.setAttribute("static", servletContext.getContextPath() + "/static");
//        servletContext.setAttribute("revision", webConfig.getRevision());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
