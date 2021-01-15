package com.team09.controller.admin;

import com.team09.bean.Blog;
import com.team09.service.BlogService;
import com.team09.service.impl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/top")
public class TopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BlogService blogService = BlogServiceImpl.getInstance();
        String blogId = request.getParameter("blogId");

        if (blogId == null || blogId.isEmpty()){

        }else {
            Blog blog = blogService.getBlogById(blogId);
            blog.setTop(!blog.isTop());
            blogService.updateBlogs(blog);
        }

        String page = request.getParameter("page");
        response.sendRedirect(request.getContextPath() + "/" + page);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
