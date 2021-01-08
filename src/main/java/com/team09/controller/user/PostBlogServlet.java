package com.team09.controller.user;

import com.team09.bean.Blog;
import com.team09.bean.User;
import com.team09.service.BlogService;
import com.team09.service.impl.BlogServiceImpl;
import com.team09.util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.Date;

/**
 * @author team09
 *  发表博客
 *  表单参数  title content keywords
 */

@WebServlet("/user/postBlog")
public class PostBlogServlet extends HttpServlet {

    private BlogService blogService = BlogServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");

        HttpSession session = req.getSession();

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String keywords = req.getParameter("keywords");

        User user = (User) session.getAttribute("userInfo");

        //将内容存入文件夹中
        content = FileUtil.writeContent(content);

        //将数据保存
        Blog blog = new Blog(title, keywords, new Date(),
                1, content,false, false, user.getId());
        if(blogService.addBlogs(blog)){
            //添加成功

            //TODO 跳转
            session.setAttribute("msg", "添加成功");
        }else{
            //添加失败

            //TODO 跳转
            session.setAttribute("msg", "添加失败");
        }

        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
