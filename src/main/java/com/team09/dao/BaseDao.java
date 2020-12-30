package com.team09.dao;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;


/**
 * @author xxx_
 */
public class BaseDao {
    protected static DataSource dataSource = null;

    static{
        try {
            Properties properties = new Properties();
            properties.load(BaseDao.class.getResourceAsStream("/dataSource.properties"));

            DruidDataSource druidDataSource = new DruidDataSource();
            druidDataSource.setDriverClassName(properties.getProperty("db.driver"));
            druidDataSource.setUrl(properties.getProperty("db.url"));
            druidDataSource.setUsername(properties.getProperty("db.username"));
            druidDataSource.setPassword(properties.getProperty("db.password"));

            dataSource = druidDataSource;

        } catch (IOException e) {
            System.out.println("读取dataSource.properties配置文件失败! ");
            e.printStackTrace();
        }
    }

}
