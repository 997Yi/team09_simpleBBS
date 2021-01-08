package com.team09.dao.impl;

import com.team09.bean.Admin;
import com.team09.dao.AdminDao;
import com.team09.dao.BaseDao;
import com.team09.util.JdbcUtil;

import java.sql.*;

/**
 * @author team09
 */
public class AdminDaoImpl extends BaseDao implements AdminDao {

    private static AdminDao adminDao = new AdminDaoImpl();

    private AdminDaoImpl(){}

    public static AdminDao getInstance(){
        return adminDao;
    }



    @Override
    public Admin getAdminById(String id) throws SQLException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("select * from admin_tb where admin_id = ? ");
            statement.setString(1, id);

            resultSet = statement.executeQuery();

            Admin admin = null;
            if(resultSet.next()){
                 admin = new Admin(resultSet.getString("admin_id"),
                         resultSet.getString("admin_name"),
                         resultSet.getString("admin_password"));
            }
            return admin;

        }finally {
            JdbcUtil.close(connection, statement, resultSet);
        }

    }

    @Override
    public Admin getAdminByName(String name) throws SQLException  {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("select * from admin_tb where admin_name = ? ");
            statement.setString(1, name);

            resultSet = statement.executeQuery();

            Admin admin = null;
            if(resultSet.next()){
                admin = new Admin(resultSet.getString("admin_id"),
                        resultSet.getString("admin_name"),
                        resultSet.getString("admin_password"));
            }
            return admin;

        }finally {
            JdbcUtil.close(connection, statement, resultSet);
        }
    }

    @Override
    public boolean updateAdmin(Admin admin) throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("update admin_tb set admin_password = ? where admin_id = ? and admin_name = ?");
            statement.setString(1, admin.getPassword());
            statement.setString(2, admin.getId());
            statement.setString(3, admin.getUsername());

            return statement.executeUpdate() != 0;
        }finally {
            JdbcUtil.close(connection, statement);
        }
    }

    @Override
    public boolean addAdmin(Admin admin) throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("insert into admin_tb value (uuid(), ?, ?)");
            statement.setString(1, admin.getUsername());
            statement.setString(2, admin.getPassword());

            return statement.executeUpdate() != 0;
        }finally {
            JdbcUtil.close(connection, statement);
        }
    }

    @Override
    public boolean deleteAdminById(String id) throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("delete from admin_tb where admin_id = ?");
            statement.setString(1, id);

            return statement.executeUpdate() != 0;
        }finally {
            JdbcUtil.close(connection, statement);
        }
    }

    @Override
    public boolean deleteAdminByName(String name) throws SQLException{
        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = dataSource.getConnection();

            statement = connection.prepareStatement("delete from admin_tb where admin_name = ?");
            statement.setString(1, name);

            return statement.executeUpdate() != 0;
        }finally {
            JdbcUtil.close(connection, statement);
        }
    }
}
