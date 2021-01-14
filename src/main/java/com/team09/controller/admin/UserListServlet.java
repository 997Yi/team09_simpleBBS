package com.team09.controller.admin;

import com.alibaba.fastjson.JSON;
import com.team09.bean.User;
import com.team09.service.UserService;
import com.team09.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/admin/list")
public class UserListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sPage=req.getParameter("page");
        int page=(sPage==null||sPage.equals("")) ?1:Integer.parseInt(sPage);
        int pageSize=4;
        req.setAttribute("page",page);
        req.setAttribute("limit",pageSize);


        UserService userService=UserServiceImpl.getInstance();
        List<User> userList=userService.findByPage(page,pageSize);

        resp.setContentType("text/html;charset=UTF-8");

        String str= JSON.toJSONString(userList);//使用fastjson
        PrintWriter out=resp.getWriter();
        out.print("{\"code\":0 , \"count\":"+ 100 +" , \"data\":"+str+"}");
    }


}