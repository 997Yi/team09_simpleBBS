package com.team09.controller.user;

import com.team09.bean.User;
import com.team09.service.UserService;
import com.team09.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //TODO jsp页面提交数据时统一数据名称
        //获取表单数据
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        String imgUrl = request.getParameter("imgUrl");
        String profile = request.getParameter("profile");


        //获取service或dao层是否成功然后返回给服务端
        UserService userService = UserServiceImpl.getInstance();
        boolean result = userService.updateUser(new User(username,passwd,imgUrl,profile));

        //TODO 不管修改是否成功都直接跳转到用户信息界面
        response.sendRedirect("    ");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
