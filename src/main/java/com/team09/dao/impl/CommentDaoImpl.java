package com.team09.dao.impl;

import com.team09.bean.Comment;
import com.team09.dao.BaseDao;
import com.team09.dao.CommentDao;
import com.team09.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author team09
 */
public class CommentDaoImpl extends BaseDao implements CommentDao {

    private static CommentDao commentDao = new CommentDaoImpl();
    private CommentDaoImpl(){}

    public static CommentDao getInstance(){
        return commentDao;
    }

    @Override
    public boolean addComment(Comment comment) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("insert into comment_tb value(uuid(), ?, ?, ?, ?, ?)");
            statement.setString(1, comment.getContent());
            statement.setString(2, comment.getStatus());
            statement.setDate(3,new Date(comment.getTime().getTime()));
            statement.setString(4, comment.getUserId());
            statement.setString(5, comment.getBlogId());

            return statement.executeUpdate() != 0;
        }finally {
            JdbcUtil.close(connection, statement);
        }
    }

    @Override
    public Comment getCommentById(String commentId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("select * from comment_tb where comment_id = ?");
            statement.setString(1, commentId);

            resultSet = statement.executeQuery();
            Comment comment = null;
            if(resultSet.next()){
                comment = new Comment(resultSet.getString("comment_id"), resultSet.getString("comment_content"),
                        resultSet.getString("comment_status"), resultSet.getDate("comment_time"),
                        resultSet.getString("user_id"), resultSet.getString("blog_id"));
            }

            return comment;
        }finally {
            JdbcUtil.close(connection, statement, resultSet);
        }
    }

    @Override
    public List<Comment> getCommentsByUserId(String userId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("select * from comment_tb where user_id = ?");
            statement.setString(1, userId);

            resultSet = statement.executeQuery();
            List<Comment> comments = new ArrayList<Comment>();
            while(resultSet.next()){
                comments.add(new Comment(resultSet.getString("comment_id"), resultSet.getString("comment_content"),
                        resultSet.getString("comment_status"), resultSet.getDate("comment_time"),
                        resultSet.getString("user_id"), resultSet.getString("blog_id")));
            }

            return comments;
        }finally {
            JdbcUtil.close(connection, statement, resultSet);
        }
    }

    @Override
    public List<Comment> getCommentsByBlogId(String blogId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("select * from comment_tb where blog_id = ?");
            statement.setString(1, blogId);

            resultSet = statement.executeQuery();
            List<Comment> comments = new ArrayList<Comment>();
            while(resultSet.next()){
                comments.add(new Comment(resultSet.getString("comment_id"), resultSet.getString("comment_content"),
                        resultSet.getString("comment_status"), resultSet.getDate("comment_time"),
                        resultSet.getString("user_id"), resultSet.getString("blog_id")));
            }

            return comments;
        }finally {
            JdbcUtil.close(connection, statement, resultSet);
        }
    }

    @Override
    public boolean deleteComment(String commentId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("delete from comment_tb where comment_id = ?");
            statement.setString(1, commentId);


            return statement.executeUpdate() != 0;
        }finally {
            JdbcUtil.close(connection, statement);
        }
    }
}
