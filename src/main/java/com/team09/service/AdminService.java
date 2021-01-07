package com.team09.service;


import com.team09.bean.Admin;

import java.sql.SQLException;

/**
 * @author team09
 */
public interface AdminService {

    /**
     * 使用id获取管理员
     * @param id
     * @return
     * @throws SQLException
     */
    public Admin getAdminById(String id);

    /**
     * 使用name获取管理员
     * @param name
     * @return
     * @throws SQLException
     */
    public Admin getAdminByName(String name);

    /**
     * 更新管理员信息
     * @param admin
     * @return
     * @throws SQLException
     */
    public boolean updateAdmin(Admin admin);

    /**
     * 添加管理员
     * @param admin
     * @return
     * @throws SQLException
     */
    public boolean addAdmin(Admin admin);


    /**
     * 根据id删除管理员
     * @param id
     * @return
     * @throws SQLException
     */
    public boolean deleteAdminById(String id);

    /**
     * 根据name删除管理员
     * @param name
     * @return
     * @throws SQLException
     */
    public boolean deleteAdminByName(String name);
}
