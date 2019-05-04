package com.chateau.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by tedu on 2017/11/27.
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("ctx", sce.getServletContext().getContextPath());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("ctx");
    }

}