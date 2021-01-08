package com.team09.controller.user;

import com.team09.bean.Comment;
import com.team09.bean.User;
import com.team09.service.CommentService;
import com.team09.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/user/PostCommentServlet")
public class PostCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户需要发布评论的博客id
        String blogId = request.getParameter("blogId");
        //获取当前用户id（session）
        String userId = ((User) request.getSession().getAttribute("userInfo")).getId();
        //获取评论等其他信息并将其创建为comment对象
        String content = request.getParameter("content");
        //TODO 时间格式待统一
        Date date = new Date();

        //调用service层将评论存储
        CommentService commentService = CommentServiceImpl.getInstance();
        commentService.addComment(new Comment(content, "正常", date, userId, blogId));

        //TODO 完成后返回到博客评论区
        response.sendRedirect("");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
