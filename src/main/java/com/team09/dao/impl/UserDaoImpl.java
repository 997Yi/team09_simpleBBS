package com.team09.dao.impl;

import com.team09.bean.User;
import com.team09.dao.BaseDao;
import com.team09.dao.UserDao;
import com.team09.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author team09
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    private static UserDao userDao = new UserDaoImpl();

    private UserDaoImpl() {
        super();
    }

    public static UserDao getInstance() {
        return userDao;
    }

    @Override
    public User getUserById(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            connection = dataSource.getConnection();

            pstmt = connection.prepareStatement("select * from user_tb where user_id=?;");
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User(rs.getString("user_id"), rs.getString("user_name"),
                        rs.getString("user_password"), rs.getString("user_img"), rs.getString("user_profile"));
            }
            return user;
        } finally {
            JdbcUtil.close(connection, pstmt, rs);
        }

    }

    @Override
    public User getUserByName(String username) throws SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            connection = dataSource.getConnection();

            pstmt = connection.prepareStatement("select * from user_tb where user_name=?;");
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                user = new User(rs.getString("user_id"), rs.getString("user_name"),
                        rs.getString("user_password"), rs.getString("user_img"), rs.getString("user_profile"));
            }
            return user;
        } finally {
            JdbcUtil.close(connection, pstmt, rs);
        }
    }

    @Override
    public boolean addUser(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();

            pstmt = connection.prepareStatement("select * from user_tb where user_name=?");
            pstmt.setString(1, user.getUsername());
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return false;
            }
            pstmt.close();
            pstmt = connection.prepareStatement("insert into user_tb values(UUID(),?,?,?,?);");
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getImgUrl());
            pstmt.setString(4, user.getProfile());
            int rows = pstmt.executeUpdate();

            return rows == 1;
        } finally {
            JdbcUtil.close(connection, pstmt, rs);
        }
    }

    @Override
    public boolean deleteUserById(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("delete from user_tb where user_id=?;");
            pstmt.setString(1, id);
            int rows = pstmt.executeUpdate();
            return rows == 1 ? true : false;
        } finally {
            JdbcUtil.close(connection, pstmt);
        }
    }

    @Override
    public boolean deleteUserByName(String username) throws SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("delete from user_tb where user_name=?;");
            pstmt.setString(1, username);
            int rows = pstmt.executeUpdate();
            return rows == 1 ? true : false;
        } finally {
            JdbcUtil.close(connection, pstmt);
        }
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("update user_tb set user_name=?,user_password=?,user_img=?,user_profile=? where user_id=?;");
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getImgUrl());
            pstmt.setString(4, user.getProfile());
            pstmt.setString(5, user.getId());
            int rows = pstmt.executeUpdate();

            return rows == 1;
        } finally {
            JdbcUtil.close(connection, pstmt);
        }
    }

    /**
     * 分页查询用户
     * @param page
     * @param pageSize
     * @return
     */
    @Override
    public List<User> findByPage(Integer page, Integer pageSize)  throws SQLException{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<User> users = new ArrayList<>();
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("select * from user_tb limit ?, ?;");

            pstmt.setInt(1, (page-1)  * pageSize);
            pstmt.setInt(2, pageSize);
            rs = pstmt.executeQuery();
            while (rs.next()){
                User  user = new User(rs.getString("user_id"), rs.getString("user_name"),
                        rs.getString("user_password"), rs.getString("user_img"), rs.getString("user_profile"));
                users.add(user);
            }
            return users;
        } finally {
            JdbcUtil.close(connection, pstmt);
        }
    }

    /**
     * 查看用户总数
     * @return
     */
    public int getUserCount() throws SQLException{
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            pstmt = connection.prepareStatement("select count(user_id) count_id from user_tb");
            rs = pstmt.executeQuery();
            int rowCount = 0;
            while (rs.next()){
                rowCount=rs.getInt("count_id");
            }
            return rowCount;
        } finally {
            JdbcUtil.close(connection, pstmt);
        }
    }
}
