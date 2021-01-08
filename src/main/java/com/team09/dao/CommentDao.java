package com.team09.dao;


import com.team09.bean.Comment;

import java.sql.SQLException;

/**
 * @author team09
 */
public interface CommentDao {

    /**
     * 添加评论
     * @param userId
     * @param comment
     * @return
     * @throws SQLException
     */
    public boolean addComment(String userId, Comment comment) throws SQLException;



}

