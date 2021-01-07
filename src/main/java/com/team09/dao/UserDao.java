package com.team09.dao;

import com.team09.bean.User;

/**
 * @author team09
 */
public interface UserDao {

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User getUserById(String id);

    /**
     * 根据username查询用户
     * @param username
     * @return
     */
    public User getUserByName(String username);

    /**
     * 添加用户
     * @param user
     * @return
     */
    public boolean addUser(User user);

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    public boolean deleteUserById(String id);

    /**
     * 根据username删除用户
     * @param username
     * @return
     */
    public boolean deleteUserByName(String username);

    /**
     * 修改用户信息
     * @param user
     * @return 原用户信息
     */
    public User updateUser(User user);
}
