package com.team09.dao;

import com.team09.bean.User;

import java.sql.SQLException;

/**
 * @author team09
 */
public interface UserDao {

    /**
     * 根据id查询用户
     * @param id
     * @return
     * @throws SQLException
     */
    public User getUserById(String id) throws SQLException;

    /**
     * 根据username查询用户
     * @param username
     * @return
     * @throws SQLException
     */
    public User getUserByName(String username) throws SQLException;

    /**
     * 添加用户
     * @param user
     * @return
     * @throws SQLException
     */
    public boolean addUser(User user) throws SQLException;

    /**
     * 根据id删除用户
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean deleteUserById(String id) throws SQLException;

    /**
     * 根据username删除用户
     * @param username
     * @return
     * @throws SQLException
     */
    public boolean deleteUserByName(String username) throws SQLException;

    /**
     * 修改用户信息
     * @param user
     * @return 原用户信息
     * @throws SQLException
     */
    public User updateUser(User user) throws SQLException;
}
