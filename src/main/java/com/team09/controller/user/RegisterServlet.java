package com.team09.controller.user;
/**
 *
 */

import com.team09.bean.User;
import com.team09.service.UserService;
import com.team09.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author team09
 * 用户注册servlet
 *  需要参数 username passwd validCode
 */
@WebServlet("/user/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取表单数据
        String username = request.getParameter("username");
        String passwd = request.getParameter("password");
        String verCode = request.getParameter("validCode").toLowerCase();

        //结果
        boolean result = false;
        String url = request.getContextPath() + "/index.jsp";


        //判断验证码是否正确(从session中获取验证码)
        HttpSession session = request.getSession();
        String rightCode = ((String) session.getAttribute("validCode")).toLowerCase();
        session.removeAttribute("validCode");

        if (rightCode.equals(verCode)) {
            //调用service层 将数据存入数据库

            UserService userService = UserServiceImpl.getInstance();
            result = userService.addUser(new User(username, passwd, null, null));

            //TODO 注册成功后跳转至登录界面
            if (result != true) {
                session.setAttribute("msg", "注册失败");
                url = request.getContextPath() + "/register.jsp";
            }else{
                session.setAttribute("userInfo", userService.getUserByName(username));
            }
        }else{
            session.setAttribute("msg", "验证码错误!");
            url = request.getContextPath() + "/register.jsp";
        }
        //4.根据结果重定向至注册界面/登录界面
        response.sendRedirect(url);
        return;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
