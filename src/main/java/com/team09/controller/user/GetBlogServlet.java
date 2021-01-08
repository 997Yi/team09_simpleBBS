package com.team09.controller.user;

import com.team09.bean.Blog;
import com.team09.bean.Comment;
import com.team09.service.BlogService;
import com.team09.service.CommentService;
import com.team09.service.impl.BlogServiceImpl;
import com.team09.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 根据id获取博客
 * 博客详细信息存于request的blog
 * 博客具体内容存于request的blogContxt
 * 获取成功后跳转至具体博客显示页面
 * 获取失败跳转至原来位置
 *
 * 同时获取评论
 */

@WebServlet("/user/lookBlog")
public class GetBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取需要详细浏览的帖子id
        String blogId = request.getParameter("blogId");

        //根据此id获取该帖子的详细信息
        BlogService blogService = BlogServiceImpl.getInstance();
        Blog blog = blogService.getBlogById(blogId);
        if (blog != null) {
            //将详细信息返回 使用request
            request.setAttribute("blog", blog);

            //将帖子具体内容返回
            InputStream is = new FileInputStream(blog.getContext());
            BufferedReader in = new BufferedReader(new InputStreamReader(is));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = in.readLine()) != null) {
                buffer.append(line);
            }
            request.setAttribute("blogContext", buffer);

            //进入service层根据博客id获取用户评论
            CommentService commentService = CommentServiceImpl.getInstance();
            List<Comment> comment = commentService.getCommentsByBlogId(blogId);

            //返回至查看评论区页面
            request.setAttribute("blogComment",comment);

            //TODO 跳转至显示详细帖子内容页面
            request.getRequestDispatcher("   ").forward(request, response);
        } else {
            //TODO 跳转至原本位置
            response.sendRedirect("");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
