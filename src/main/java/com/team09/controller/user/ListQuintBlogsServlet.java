package com.team09.controller.user;

import com.team09.bean.Blog;
import com.team09.bean.User;
import com.team09.service.BlogService;
import com.team09.service.UserService;
import com.team09.service.impl.BlogServiceImpl;
import com.team09.service.impl.UserServiceImpl;
import com.team09.util.FileUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：xxx_
 * @date ：Created in 2021/1/13 4:57 下午
 * @description：显示所有精华贴
 * @modified By：
 * @version: 1.0
 */
@WebServlet("/user/listQuintBlogs")
public class ListQuintBlogsServlet extends HttpServlet {
    BlogService blogService = BlogServiceImpl.getInstance();
    UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Blog> quintBlogs = blogService.getQuintBlogs();
        Map<Blog, User> map = new HashMap<>();
        for(Blog blog : quintBlogs){
            User user = userService.getUserById(blog.getUserId());
            user.setImgUrl(FileUtil.getImg(user.getImgUrl()));
            map.put(blog, user);
        }

        HttpSession session = req.getSession();
        session.setAttribute("blogList", map);

        req.getRequestDispatcher("/view/quintessenceBlogs.jsp").forward(req, resp);
    }
}
