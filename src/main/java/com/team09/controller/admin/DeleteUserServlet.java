package com.team09.controller.admin;

import com.team09.service.AdminService;
import com.team09.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user/del.do")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId= req.getParameter("id");
        int id=(sId==null||sId.equals("")) ?0:Integer.parseInt(sId);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();

        AdminService userService=new AdminServiceImpl();
        if (userService.deleteAdminById(id)){
            out.println("<script>alert('成功删除id="+id+"');window.location.href='list'</script>");
        }else {
            out.println("<script>alert('删除失败id="+id+"');window.location.href='list'</script>");
        }
        out.close();
    }


}