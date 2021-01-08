package com.team09.controller.user;

import com.team09.bean.Blog;
import com.team09.bean.User;
import com.team09.service.BlogService;
import com.team09.service.impl.BlogServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author team09
 */
@WebServlet("/user/delBlog")
public class DeleteBlogServlet extends HttpServlet {
    BlogService blogService = BlogServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");

        HttpSession session = req.getSession();
        String blogId = req.getParameter("blogId");
        if(blogId == null || blogId.equals("")){
            //TODO 提示无效
        }else{

            User userInfo = (User)session.getAttribute("userInfo");
            Blog blog = blogService.getBlogById(blogId);

            if(!userInfo.getId().equals(blog.getUserId())){
                //TODO 提示无权限的非法删除
            }else{

                if(blogService.deleteBlogs(blog)){
                    //TODO 删除成功
                }else{
                    //TODO 删除失败
                }

            }
        }
    }
}
