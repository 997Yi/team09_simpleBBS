package com.team09.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author team09
 */
public class JdbcUtil {
    public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException{
        if(resultSet != null){
            resultSet.close();
        }
        if(statement != null){
            statement.close();
        }
        if(connection != null){
            connection.close();
        }
    }

    public static void close(Connection connection, Statement statement) throws SQLException {
        close(connection, statement, null);
    }
}
