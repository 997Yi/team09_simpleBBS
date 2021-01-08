package com.team09.controller.user;

import com.team09.bean.User;
import com.team09.service.UserService;
import com.team09.service.impl.UserServiceImpl;
import com.team09.util.FileUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author taem09
 *  修改用户信息
 *      参数 username password image profile
 *      均为必填，若不修改则填入原值
 */
@WebServlet("/user/modifyUser")

public class ModifyUserServlet extends HttpServlet {
    UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //TODO jsp页面提交数据时统一数据名称
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");

        String username = null;
        String password = null;
        String image = null;
        String profile = null;

        try {
            //创建ServletFileUpload对象
            ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

            //解析表单字段
            List<FileItem> itemList=upload.parseRequest(req);

            //遍历取表单内容
            for(FileItem fileItem : itemList){

                if (fileItem.isFormField()){
                    //普通表单字段

                    if (fileItem.getFieldName().equals("username")){
                        username = fileItem.getString("UTF-8");

                    }else if (fileItem.getFieldName().equals("password")){
                        password = fileItem.getString("UTF-8");

                    }else if (fileItem.getFieldName().equals("profile")){
                        profile = fileItem.getString("UTF-8");

                    }

                }else {
                    //保存
                    image = FileUtil.saveImg(fileItem);
                }
            }
        }catch (FileUploadBase.InvalidContentTypeException e){
            //提交非法表单 表单中不包含multipart/form-data或multipart/mixed
            System.out.println("提交非法表单");
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }


        User user = (User)req.getSession().getAttribute("userInfo");
        user.setUsername(username);
        user.setImgUrl(image);
        user.setProfile(profile);
        user.setPassword(password);

        if(userService.updateUser(user)){
            //TODO 修改成功后逻辑代码
        }else{
            //TODO 修改失败后逻辑代码
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
