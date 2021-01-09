package com.team09.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


//@WebFilter(filterName = "UserLoginFilter",urlPatterns = {"/*"})
public class UserLoginFilter implements Filter {
    String[] permitUrls=null;
    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        System.out.println("LoginFilter: requestURI= "+request.getRequestURI());
        boolean flag =false;
        for (String url:permitUrls){
            if (request.getRequestURI().endsWith(url)){
                flag=true;
            }
        }

        if (flag||request.getSession().getAttribute("user")!=null){
            System.out.println("~~~~~~~~~~~~~~允许登录");
            chain.doFilter(req, resp);
        }else {
            System.out.println("~~~~~~~~~~~~~~不允许登录");
            request.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }
    @Override
    public void init(FilterConfig config) throws ServletException {
        permitUrls=config.getInitParameter("permitUrls").split(",");
    }

}