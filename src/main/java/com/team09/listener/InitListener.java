package com.team09.listener;

import com.team09.util.FileUtil;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/13 7:45 下午
 * @description：容器创建监听器
 * @modified By：
 * @version: 1.0
 */
@WebListener
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        FileUtil.setPath(sce.getServletContext().getRealPath(""));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
