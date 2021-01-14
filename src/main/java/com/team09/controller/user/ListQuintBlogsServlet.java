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
        String page = req.getParameter("page");
        HttpSession session = req.getSession();

        if(page == null || page.equals("")){
            page = "1";
        }

        int pageNum = Integer.parseInt(page);

        List<Blog> quintBlogs = blogService.getQuintBlogs();

        if(pageNum - 1 > quintBlogs.size() / 5){
            session.setAttribute("mag", "非法分页参数");
            req.getRequestDispatcher(req.getContextPath() + "/user/listBlog").forward(req, resp);
            return;
        }

        Map<Blog, User> map = new HashMap<>();
        //按排序后的顺序获取单页数据
        for(int i = (pageNum - 1) * 5; i < Math.min(quintBlogs.size(), i + 5); i++){
            Blog blog = quintBlogs.get(i);
            User userById = userService.getUserById(blog.getUserId());
            userById.setImgUrl(FileUtil.getImg(userById.getImgUrl()));
            map.put(blog, userById);
        }

        session.setAttribute("blogList", map);

        req.getRequestDispatcher("/view/quintessenceBlogs.jsp").forward(req, resp);
    }
}
