package com.team09.controller.user;

import com.team09.bean.Comment;
import com.team09.bean.User;
import com.team09.dao.CommentDao;
import com.team09.service.CommentService;
import com.team09.service.impl.CommentServiceImpl;

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
@WebServlet("/user/delComment")
public class DeleteCommentServlet extends HttpServlet {
    CommentService commentService = CommentServiceImpl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html; charset=UTF-8");

        HttpSession session = req.getSession();

        String commentId = req.getParameter("commentId");
        Comment comment = commentService.getCommentById(commentId);

        if(comment == null){
            //TODO 非法的参数
        }else{

            User user = (User) session.getAttribute("userInfo");
            if(!user.getId().equals(comment.getUserId())){
                //TODO 非法的删除
            }else{

                if(commentService.deleteComment(commentId)){
                    //TODO 删除成功
                }else{
                    //TODO 删除失败
                }
            }
        }
    }
}
