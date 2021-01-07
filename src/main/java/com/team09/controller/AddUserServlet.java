package com.team09.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户信息 userid自动生成

        String username= request.getParameter("username");

        String password= request.getParameter("password");

        String imgUrl= request.getParameter("imgUrl");

        String profile= request.getParameter("profile");

        //传给service层 让service层判断信息是否完整（如必填字段是否为空）


        //获取service层返回的信息 返回给前端


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
