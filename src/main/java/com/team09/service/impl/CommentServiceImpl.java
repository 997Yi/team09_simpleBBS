package com.team09.service.impl;

import com.team09.bean.Comment;
import com.team09.dao.CommentDao;
import com.team09.dao.impl.CommentDaoImpl;
import com.team09.service.AdminService;
import com.team09.service.CommentService;

import java.sql.SQLException;
import java.util.List;

public class CommentServiceImpl implements CommentService {

    private static  CommentService  commentService = new  CommentServiceImpl();

    private  CommentServiceImpl(){}

    public static  CommentService getInstance(){
        return  commentService;
    }

    CommentDao commentDao = CommentDaoImpl.getInstance();

    @Override
    public boolean addComment(Comment comment) {
        try {
            return  commentDao.addComment(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Comment getCommentById(String commentId) {
        try {
            return  commentDao.getCommentById(commentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Comment> getCommentsByUserId(String userId) {
        try {
            return  commentDao.getCommentsByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Comment> getCommentsByBlogId(String blogId) {
        try {
            return  commentDao.getCommentsByBlogId(blogId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteComment(String commentId) {
        try {
            return  commentDao.deleteComment(commentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
