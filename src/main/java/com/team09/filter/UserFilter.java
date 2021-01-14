package com.team09.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {
        "/user/delBlog", "/user/delComment", "/user/modifyUser",
        "/user/postBlog", "/user/PostCommentServlet", "/view/postBlog.jsp",
        "/view/listSelfBlog.jsp", "/view/modifyBlog.jsp"})
public class UserFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (httpServletRequest.getSession().getAttribute("userInfo") != null) {
            chain.doFilter(request, response);
        }else {
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
