package com.team09.service.impl;

import com.team09.bean.Blog;
import com.team09.bean.User;
import com.team09.dao.BlogDao;
import com.team09.dao.impl.BlogDaoImpl;
import com.team09.service.AdminService;
import com.team09.service.BlogService;

import java.sql.SQLException;
import java.util.List;

public class BlogServiceImpl implements BlogService {

    private static BlogService blogService = new BlogServiceImpl();

    private BlogServiceImpl(){}

    public static BlogService getInstance(){
        return blogService;
    }

    private static BlogDao blogDao = BlogDaoImpl.getInstance();

    @Override
    public Blog getBlogById(String id) {
        try {
            return blogDao.getBlogById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Blog> getBlogByUserId(String userId) {
        try {
            return blogDao.getBlogByUserId(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Blog> getAllBlogs() {
        try {
            return blogDao.getAllBlogs();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addBlogs(Blog blog) {
        try {
            return blogDao.addBlogs(blog);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteBlogs(Blog blog) {
        try {
            return blogDao.deleteBlogs(blog.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateBlogs(Blog blog) {
        try {
            return blogDao.updateBlogs(blog);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}