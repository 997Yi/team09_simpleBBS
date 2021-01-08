package com.team09.service.impl;

import com.team09.bean.Admin;
import com.team09.dao.AdminDao;
import com.team09.dao.impl.AdminDaoImpl;
import com.team09.service.AdminService;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {

    private static AdminService adminService = new AdminServiceImpl();

    public AdminServiceImpl(){}

    public static AdminService getInstance(){
        return adminService;
    }

    private static AdminDao adminDao = AdminDaoImpl.getInstance();

    @Override
    public Admin getAdminById(String id) {
        try {
            if (id == null || id.isEmpty()){
                return null;
            }
            return adminDao.getAdminById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Admin getAdminByName(String name) {
        try {
            if (name == null || name.isEmpty()){
                return null;
            }
            return adminDao.getAdminByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean updateAdmin(Admin admin) {
        try {
            if (admin == null){
                return false;
            }
            return adminDao.updateAdmin(admin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addAdmin(Admin admin) {
        try {
            if (admin == null){
                return false;
            }
            return adminDao.addAdmin(admin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAdminById(int id) {
        return false;
    }


    public boolean deleteAdminById(String id) {
        try {
            if (id == null || id.isEmpty()){
                return false;
            }
            return adminDao.deleteAdminById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAdminByName(String name) {
        try {
            if (name == null || name.isEmpty()){
                return false;
            }
            return adminDao.deleteAdminByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
