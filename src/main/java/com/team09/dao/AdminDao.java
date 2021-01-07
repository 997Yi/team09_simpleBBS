package com.team09.dao;


import com.team09.bean.Admin;

/**
 * @author team09
 */
public interface AdminDao {

    /**
     * 使用id获取管理员
     * @param id
     * @return
     */
    public Admin getAdminById(String id);

    /**
     * 使用name获取管理员
     * @param name
     * @return
     */
    public Admin getAdminByName(String name);

    /**
     * 更新管理员信息
     * @param admin
     * @return
     */
    public Admin updateAdmin(Admin admin);

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    public boolean addAdmin(Admin admin);


    /**
     * 根据id删除管理员
     * @param id
     * @return
     */
    public boolean deleteAdminById(String id);

    /**
     * 根据name删除管理员
     * @param name
     * @return
     */
    public boolean deleteAdminByName(String name);
}
