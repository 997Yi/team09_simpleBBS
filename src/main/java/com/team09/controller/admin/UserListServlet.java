package com.team09.controller.admin;

import com.team09.bean.User;
import com.team09.service.UserService;
import com.team09.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/list")
public class UserListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sPage=req.getParameter("page");
        int page=(sPage==null||sPage.equals("")) ?1:Integer.parseInt(sPage);
        int pageSize=4;
        req.setAttribute("page",page);
        req.setAttribute("pageSize",pageSize);


        UserService userService=new UserServiceImpl();
        List<User> userList=userService.findByPage(page,pageSize);
        req.setAttribute("userList",userList);
        req.getRequestDispatcher("../userList.jsp").forward(req,resp);
    }


}