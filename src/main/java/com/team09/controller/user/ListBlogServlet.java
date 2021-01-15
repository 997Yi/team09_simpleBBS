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
import java.util.*;

/**
 * 查看全部博客
 * 返回数据存储于session中名为bolgs
 * 完成后重定向于显示所有博客界面
 */
@WebServlet("/user/listBlog")
public class ListBlogServlet extends HttpServlet {
    BlogService blogService = BlogServiceImpl.getInstance();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String page = request.getParameter("page");

        HttpSession session = request.getSession();

        List<Blog> blogs;
        String url = "/index.jsp";

        if(id == null || id.equals("")){
            blogs = blogService.getAllBlogs();
        } else{
            blogs = blogService.getBlogByUserId(id);
            url = "/view/listSelfBlog.jsp";
        }


        // 把精华和置顶博客排序放在前面
        if(!blogs.isEmpty()){
            Collections.sort(blogs, new Comparator<Blog>() {
                @Override
                public int compare(Blog o1, Blog o2) {
                    if (o1.isQuintessence() != o2.isQuintessence()) {
                        return o1.isQuintessence() == true ? -1 : 1;
                    }
                    if (o1.isTop() != o2.isTop()) {
                        return o1.isTop() == true ? -1 : 1;
                    }
                    return 0;
                }
            });
        }

        for(Blog blog:blogs){
            System.out.println(blog.getTitle());
        }
        System.out.println("--------------------");

        if(page == null || page == ""){
            page = "1";
        }
        //获取页数值
        int pageNum = Integer.parseInt(page);
        //当前页数超过数据数 非法查询
        if(pageNum - 1 > blogs.size() / 5){
            session.setAttribute("mag", "非法分页参数");
            request.getRequestDispatcher(url).forward(request, response);
            return;
        }

        //把博客和发博客用户信息利用map作为映射同时保存在session中
        Map<Blog, User> map = new HashMap<>();
        UserService userService = UserServiceImpl.getInstance();

        //按排序后的顺序获取单页数据
        for(int i = (pageNum - 1) * 5; i < Math.min(blogs.size(), i + 5); i++){
            Blog blog = blogs.get(i);
            User userById = userService.getUserById(blog.getUserId());
            userById.setImgUrl(FileUtil.getImg(userById.getImgUrl()));
            map.put(blog, userById);
        }

        //将所有博客返回给前端 存储在session中
        session.setAttribute("mapBlogs", map);
        session.setAttribute("blogNums", blogs.size());

        request.getRequestDispatcher(url).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
