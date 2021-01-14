<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>修改信息</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <style>
        .upload-wrap{
            position: relative;
            overflow: hidden;
            border:1px solid #2d78f4;
            border-radius: 3px;
            display: inline-block;
            margin-left: 10%;
        }
        .upload-wrap .file-ele{
            position: absolute;
            top:0;
            right:0;
            opacity: 0;
            height: 100%;
            width: 100%;
            cursor: pointer;
        }
        .upload-wrap .file-open{
            width:90px;
            height:30px;
            line-height:30px;
            text-align: center;
            color:#fff;
            background: #3385ff;
        }
        .show-img{
            display: inline-block;
            float: right;
            margin-right: 10%;
        }
    </style>
</head>
<body class="layui-layout-body" style="overflow: auto">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">simpleBBS 简易博客</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user/listBlog">主页</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/view/quintessenceBlogs.jsp">精华帖</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/view/postBlog.jsp">发布博客</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-this">
                <a href="javascript:;">
                    <jstl:if test="${userInfo.imgUrl == null}">
                        <img src= "${pageContext.request.contextPath}/image/default.png" class="layui-nav-img">
                    </jstl:if>
                    <jstl:if test="${userInfo.imgUrl != null}">
                        <img src= "${pageContext.request.contextPath}${userInfo.imgUrl}" class="layui-nav-img">
                    </jstl:if>
                    ${userInfo.username}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="${pageContext.request.contextPath}/view/modifyInfo.jsp">修改信息</a></dd>
                    <dd><a href="${pageContext.request.contextPath}/user/listBlog?id=${userInfo.id}">查看我的博客</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/logout">退出登录</a></li>
        </ul>
    </div>
    <div class="layui-input-block" style="border: 1px solid #e0e0e0; width: 50%; margin: 150px auto; padding: 30px 0 10px 0;background-color: #f8f8f8;">
        <h2 style="text-align: center; margin-bottom: 30px">修改信息</h2>
        <form class="layui-form" action="${pageContext.request.contextPath}/user/modifyUser" method="post" style="width: 80%; margin: 0 auto" enctype="multipart/form-data">
            <div style="margin: 0 auto; width: 60%" >
                <div class="layui-form-item" >
                    <div class="layui-input-block" style="margin-left: 0px;">
                        <input type="text" name="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input" value="${userInfo.username}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin-left: 0px;">
                        <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input" value="${userInfo.password}">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin: 0px;">
                        <div class="upload-wrap anticon" nv-file-drop="" uploader="uploader">
                            <input class="file-ele" type="file" file-model="image" name="image" nv-file-select uploader="uploader" multiple />
                            <div class="file-open"><em class="icon icon-upload"></em>&nbsp;修改头像</div>
                        </div>
                        <div class="show-img">
                            旧头像:
                            <jstl:if test="${userInfo.imgUrl == null}">
                                <img src= "${pageContext.request.contextPath}/image/default.png" style="width: 50px; height: auto">
                            </jstl:if>
                            <jstl:if test="${userInfo.imgUrl != null}">
                                <img src= "${pageContext.request.contextPath}${userInfo.imgUrl}" style="width: 50px; height: auto">
                            </jstl:if>
                        </div>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin: 0px;">
                        <textarea name="profile" placeholder="个人简介" class="layui-textarea" ><jstl:if test="${userInfo.profile != null}">${userInfo.profile}</jstl:if></textarea>
                    </div>
                </div>
            </div>
            <div style="margin: 0 auto; width: 40%" >
                <div class="layui-form-item">
                </div>
                <div class="layui-input-block" style="margin: 0 0 20px 0; text-align: center;">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">提交修改</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>

</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    layui.use(['form', 'element'], function () {
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function (data) {
        });
    });
</script>
<jstl:if test="${msg != null}">
    <script>
        alert("${msg}");
    </script>
    <% session.setAttribute("msg", null); %>
</jstl:if>
</body>
</html>