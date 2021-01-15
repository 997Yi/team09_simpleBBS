package com.team09.controller.user;

import com.team09.bean.Blog;
import com.team09.bean.Comment;
import com.team09.bean.User;
import com.team09.service.BlogService;
import com.team09.service.CommentService;
import com.team09.service.impl.BlogServiceImpl;
import com.team09.service.impl.CommentServiceImpl;
import com.team09.util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
        HttpSession session = req.getSession();
        String blogId = req.getParameter("blogId");
        User userInfo = (User) session.getAttribute("userInfo");


        if(blogId == null || blogId.equals("")){
            session.setAttribute("msg", "无效的参数");
        }else{

            Blog blog = blogService.getBlogById(blogId);

            if(!userInfo.getId().equals(blog.getUserId())){
                session.setAttribute("msg", "无权限的非法删除");
            }else{

                if(blogService.deleteBlogs(blog)){
                    session.setAttribute("msg", "删除成功");
                    // 删除文件
                    FileUtil.deleteContent(blog.getContext());
                }else{
                    session.setAttribute("msg", "删除失败");
                }

            }
        }

        resp.sendRedirect(req.getContextPath() + "/user/listBlog?id=" + userInfo.getId());
        return;
    }
}
