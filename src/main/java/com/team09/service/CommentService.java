package com.team09.service;

import com.team09.bean.Comment;

import java.util.List;

public interface CommentService {

    /**
     * 添加评论
     * @param comment
     * @return
     */
    public boolean addComment(Comment comment) ;

    /**
     * 通过评论id获取评论
     * @param commentId
     * @return
     */
    public Comment getCommentById(String commentId) ;

    /**
     * 通过用户id查询评论
     * @param userId
     * @return
     */
    public List<Comment> getCommentsByUserId(String userId) ;

    /**
     * 通过博客id查询评论
     * @param blogId
     * @return
     */
    public List<Comment> getCommentsByBlogId(String blogId) ;


    /**
     * 删除评论
     * @param commentId
     * @return
     */
    public boolean deleteComment(String commentId) ;
}
