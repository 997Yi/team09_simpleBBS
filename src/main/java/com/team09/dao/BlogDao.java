package com.team09.dao;


import com.team09.bean.Blog;
import com.team09.bean.User;

import java.util.List;

/**
 * @author team09
 */
public interface BlogDao {

    /**
     * 根据id获取博客信息
     * @param id
     * @return
     */
    public Blog getBlogById(String id);

    /**
     * 根据用户id查询他发布的所有博客
     * @param userId
     * @return
     */
    public List<Blog> getBlogByUserId(String userId);

    /**
     * 获取所有博客
     * @return
     */
    public List<Blog> getAllBlogs();

    /**
     * 创建新的博客（需要操作blog_tb和user_blog_tb）
     * @param user
     * @param blog
     * @return
     */
    public boolean addBlogs(User user, Blog blog);

    /**
     * 删除博客
     * @param blog
     * @return
     */
    public boolean deleteBlogs(Blog blog);


    /**
     * 修改博客
     * @param blog
     * @return
     */
    public Blog updateBlogs(Blog blog);
}
