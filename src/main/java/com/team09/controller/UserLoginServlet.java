package com.team09.controller;

import com.team09.bean.Admin;
import com.team09.bean.User;
import com.team09.service.AdminService;
import com.team09.service.UserService;
import com.team09.service.impl.AdminServiceImpl;
import com.team09.service.impl.UserServiceImpl;

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

@WebServlet("/userLogin")
public class UserLoginServlet extends HttpServlet {

    private UserService userService = UserServiceImpl.getInstance();
    private AdminService adminService = AdminServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");

        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String validCode = req.getParameter("validCode");

        String realCode = (String) session.getAttribute("validCode");
        session.removeAttribute("validCode");

        if(!validCode.toLowerCase().equals(realCode)){
            //验证码有误
            session.setAttribute("msg", "验证码错误");
            //TODO 返回注册页面
            return;
        }


        User userInfo = userService.getUserByName(username);

        if(userInfo == null){
            //账号不存在

            session.setAttribute("msg", "该账号不存在，检查后重试");
            //TODO 返回注册页面
            return;
        }else if(!userInfo.getPassword().equals(password)){
            //账号密码不匹配

            session.setAttribute("msg", "账号密码不匹配，检查后重试");
            //TODO 返回注册页面
            return;
        }else{
            //登陆成功
            session.setAttribute("userInfo", userInfo);
            //TODO 跳转到博客首页
        }

    }
}
