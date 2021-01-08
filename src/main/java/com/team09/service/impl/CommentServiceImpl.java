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
            if (comment == null){
                return false;
            }
            return  commentDao.addComment(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Comment getCommentById(String commentId) {
        try {
            if (commentId == null || commentId.isEmpty()){
                return null;
            }
            return  commentDao.getCommentById(commentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Comment> getCommentsByUserId(String userId) {
        try {
            if (userId == null || userId.isEmpty()){
                return null;
            }
            return  commentDao.getCommentsByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Comment> getCommentsByBlogId(String blogId) {
        try {
            if (blogId == null || blogId.isEmpty()){
                return null;
            }
            return  commentDao.getCommentsByBlogId(blogId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteComment(String commentId) {
        try {
            if (commentId == null || commentId.isEmpty()){
                return false;
            }
            return  commentDao.deleteComment(commentId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
