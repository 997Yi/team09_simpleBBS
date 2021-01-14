package com.team09.controller.admin;

import com.team09.bean.Blog;
import com.team09.service.AdminService;
import com.team09.service.BlogService;
import com.team09.service.UserService;
import com.team09.service.impl.AdminServiceImpl;
import com.team09.service.impl.BlogServiceImpl;
import com.team09.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/del")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = UserServiceImpl.getInstance();
        String userId = req.getParameter("userId");
        userService.deleteUserById(userId);

        BlogService blogService = BlogServiceImpl.getInstance();
        List<Blog> blogs = blogService.getBlogByUserId(userId);
        for (Blog blog : blogs){
            blogService.deleteBlogs(blog);
        }
    }


}