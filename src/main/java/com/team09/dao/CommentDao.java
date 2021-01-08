package com.team09.dao;


import com.team09.bean.Blog;
import com.team09.bean.Comment;

import java.sql.SQLException;
import java.util.List;

/**
 * @author team09
 */
public interface CommentDao {

    /**
     * 添加评论
     * @param comment
     * @return
     * @throws SQLException
     */
    public boolean addComment(Comment comment) throws SQLException;

    /**
     * 通过评论id获取评论
     * @param commentId
     * @return
     * @throws SQLException
     */
    public Comment getCommentById(String commentId) throws SQLException;

    /**
     * 通过用户id查询评论
     * @param userId
     * @return
     * @throws SQLException
     */
    public List<Comment> getCommentsByUserId(String userId) throws SQLException;

    /**
     * 通过博客id查询评论
     * @param blogId
     * @return
     * @throws SQLException
     */
    public List<Comment> getCommentsByBlogId(String blogId) throws SQLException;


    /**
     * 删除评论
     * @param commentId
     * @return
     * @throws SQLException
     */
    public boolean deleteComment(String commentId) throws SQLException;

}


