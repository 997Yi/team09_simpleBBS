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
import java.io.IOException;
import java.util.*;

/**
 * 查看全部博客
 * 返回数据存储于session中名为bolgs
 * 完成后重定向于显示所有博客界面
 */
@WebServlet("/user/listBlog")
public class ListBlogServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据库中所有博客
        BlogService blogService = BlogServiceImpl.getInstance();
        List<Blog> blogs = blogService.getAllBlogs();

        // 把精华和置顶博客排序放在前面
        Collections.sort(blogs, new Comparator<Blog>() {
            @Override
            public int compare(Blog o1, Blog o2) {
                if (o1.isQuintessence() != o2.isQuintessence()) {
                    return o1.isQuintessence() == true ? 1 : -1;
                }
                if (o1.isTop() != o2.isTop()) {
                    return o1.isTop() == true ? 1 : -1;
                }
                return 0;
            }
        });

        //把博客和发博客用户信息利用map作为映射同时保存在session中
        Map<Blog, User> map = new HashMap<>();
        UserService userService = UserServiceImpl.getInstance();

        for (Blog blog : blogs) {
            User userById = userService.getUserById(blog.getUserId());
            userById.setImgUrl(FileUtil.getImg(userById.getImgUrl()));
            map.put(blog, userById);
        }

        //将所有博客返回给前端 存储在session中
        request.getSession().setAttribute("mapBlogs", map);

        //TODO 重定向至显示所有博客界面
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
