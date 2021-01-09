package com.team09.listener;

import com.team09.bean.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@WebListener()
public class AdminOnlineListener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {
    List<User> onlineUser;
    // Public constructor is required by servlet spec
    public AdminOnlineListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("创建");
        if (onlineUser==null)
        {
            onlineUser=new ArrayList<>();
        }

        sce.getServletContext().setAttribute("online",onlineUser);
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context
         (the Web application) is undeployed or
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------
    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        if (sbe.getName().equals("user")){
            System.out.println("添加");
            onlineUser.add((User)sbe.getValue());
        }
        sbe.getSession().getServletContext().setAttribute("online",onlineUser);
    }
    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        System.out.println("移除");
        if (sbe.getName().equals("user")){
            onlineUser.remove((User)sbe.getValue());
        }
        sbe.getSession().getServletContext().setAttribute("online",onlineUser);
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        if (sbe.getName().equals("user")){
            System.out.println((User)sbe.getValue());
            if (!onlineUser.contains((User)sbe.getValue())){
                onlineUser.add((User)sbe.getValue());
                sbe.getSession().getServletContext().setAttribute("online",onlineUser);
            }

        }

    }
}