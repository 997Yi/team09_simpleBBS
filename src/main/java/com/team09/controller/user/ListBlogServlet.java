package com.team09.controller.user;
/**
 * 查看全部博客
 */

import com.team09.bean.Blog;
import com.team09.service.BlogService;
import com.team09.service.impl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/listBlog")
public class ListBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取数据库中所有博客
        BlogService blogService = BlogServiceImpl.getInstance();
        List<Blog> blogs = blogService.getAllBlogs();

        //将所有博客返回给前端
        //TODO 存储位置是否需要改变？session/request
        request.setAttribute("blogs",blogs);

        //TODO 重定向至显示所有博客界面
        response.sendRedirect("");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
