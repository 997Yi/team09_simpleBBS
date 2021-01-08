package com.team09.dao.impl;

import com.team09.bean.Blog;
import com.team09.bean.User;
import com.team09.dao.BaseDao;
import com.team09.dao.BlogDao;
import com.team09.util.JdbcUtil;

import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDaoImpl extends BaseDao implements BlogDao {

    private static BlogDao blogDao = new BlogDaoImpl();

    private BlogDaoImpl(){}

    public static BlogDao getInstance(){
        return blogDao;
    }



    @Override
    public Blog getBlogById(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("select * from blog_tb where blog_id = ?");
            statement.setString(1, id);

            resultSet = statement.executeQuery();

            Blog blog = null;
            if(resultSet.next()){
                blog = new Blog(resultSet.getString("blog_id"),
                        resultSet.getString("blog_title"), resultSet.getString("blog_keywords"),
                        resultSet.getDate("blog_time"), resultSet.getInt("blog_clicks"),
                        resultSet.getString("blog_content"), resultSet.getInt("top") == 1,
                        resultSet.getInt("quintessence") == 1, resultSet.getString("user_id"));
            }
            return blog;
        }finally {
            JdbcUtil.close(connection, statement, resultSet);
        }
    }

    @Override
    public List<Blog> getBlogByUserId(String userId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("select * from blog_tb where user_id = ?");
            statement.setString(1, userId);

            resultSet = statement.executeQuery();

            List<Blog> list = new ArrayList<Blog>();
            while(resultSet.next()){
                //String id, String title, String keyWords, Date time, int clicks, String context, boolean isTop, boolean isQuintessence, String userId
                list.add(new Blog(resultSet.getString("blog_id"),
                        resultSet.getString("blog_title"), resultSet.getString("blog_keywords"),
                        resultSet.getDate("blog_time"), resultSet.getInt("blog_clicks"),
                        resultSet.getString("blog_content"), resultSet.getInt("top") == 1,
                        resultSet.getInt("quintessence") == 1, resultSet.getString("user_id")));
            }
            return list;

        }finally {
            JdbcUtil.close(connection, statement, resultSet);
        }
    }

    @Override
    public List<Blog> getAllBlogs() throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("select * from blog_tb");

            resultSet = statement.executeQuery();

            List<Blog> list = new ArrayList<Blog>();
            while(resultSet.next()){
                list.add(new Blog(resultSet.getString("blog_id"),
                        resultSet.getString("blog_title"), resultSet.getString("blog_keywords"),
                        resultSet.getDate("blog_time"), resultSet.getInt("blog_clicks"),
                        resultSet.getString("blog_content"), resultSet.getInt("top") == 1,
                        resultSet.getInt("quintessence") == 1, resultSet.getString("user_id")));
            }
            return list;

        }finally {
            JdbcUtil.close(connection, statement, resultSet);
        }
    }

    @Override
    public boolean addBlogs(Blog blog) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("select uuid()");
            resultSet = statement.executeQuery();
            resultSet.next();
            blog.setId(resultSet.getString(1));

            statement.close();

            statement = connection.prepareStatement("insert into blog_tb value (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, blog.getId());
            statement.setString(2, blog.getTitle());
            statement.setString(3, blog.getContext());
            statement.setString(4, blog.getKeyWords());
            statement.setInt(5, blog.getClicks());
            statement.setDate(6, new Date(blog.getTime().getTime()));
            statement.setInt(7, blog.isTop() ? 1 : 0);
            statement.setInt(8, blog.isQuintessence() ? 1 : 0);
            statement.setString(9, blog.getUserId());
            return statement.executeUpdate() != 0;

        }finally {
            JdbcUtil.close(connection, statement, resultSet);
        }
    }

    @Override
    public boolean deleteBlogs(String blogId) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("delete from blog_tb where blog_id = ?");
            statement.setString(1, blogId);

            return statement.executeUpdate() != 0;
        }finally {
            JdbcUtil.close(connection, statement);
        }
    }

    @Override
    public boolean updateBlogs(Blog blog) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("update blog_tb set blog_title=?, blog_content=?, blog_keywords=?" +
                    ", blog_clicks=?, blog_time=?, top=?, quintessence=?, uuser_id=? where blog_id = ?");
            statement.setString(1, blog.getTitle());
            statement.setString(2, blog.getContext());
            statement.setString(3, blog.getKeyWords());
            statement.setInt(4, blog.getClicks());
            statement.setDate(5, new Date(blog.getTime().getTime()));
            statement.setInt(6, blog.isTop() ? 1 : 0);
            statement.setInt(7, blog.isQuintessence() ? 1 : 0);
            statement.setString(8, blog.getUserId());
            statement.setString(9, blog.getId());

            return statement.executeUpdate() != 0;
        }finally {
            JdbcUtil.close(connection, statement);
        }
    }
}
