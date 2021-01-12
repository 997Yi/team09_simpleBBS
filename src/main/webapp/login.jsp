<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>登陆</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">simpleBBS 简易博客</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="user/listBlog">主页</a></li>
            <li class="layui-nav-item"><a href="">精华帖</a></li>
            <li class="layui-nav-item"><a href="">发布博客</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item  layui-this">
                <a href="login.jsp">
                    点击登陆
                </a>
            </li>
        </ul>
    </div>

    <div class="layui-input-block" style="border: 1px solid #e0e0e0; width: 50%; margin: 150px auto; padding: 30px 0 10px 0;background-color: #f8f8f8;">
        <h2 style="text-align: center; margin-bottom: 30px">登陆页面</h2>
        <form class="layui-form" action="${pageContext.request.contextPath}/login" method="post" style="width: 80%; margin: 0 auto">
            <div style="margin: 0 auto; width: 60%" >
                <div class="layui-form-item" >
                    <div class="layui-input-block" style="margin-left: 0px;">
                        <input type="text" name="username" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin-left: 0px;">
                        <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin: 0px;">
                        <input type="text" name="validCode" required lay-verify="required" placeholder="输入验证码" autocomplete="off" class="layui-input" style="width: 60%; margin:0; display:inline-block;"
                        ><img src="${pageContext.request.contextPath}/validCode" style="height: auto; width: 30%; margin-left: 10%;">
                    </div>
                </div>
            </div>
            <div style="margin: 0 auto; width: 40%" >
                <div class="layui-form-item">
                </div>
                <div class="layui-input-block" style="margin-left: 0px; text-align: center;">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">登陆</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
                <div class="layui-input-block" style="margin-top: 40px; font-size: 14px; margin-left: 0px; text-align: center;">
                    还没有账号？
                    <a href="register.jsp">点击注册</a>
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
    <% session.removeAttribute("msg"); %>
</jstl:if>

<jstl:if test="${userInfo != null}">
    <script>
        window.location.href="index.jsp";
    </script>
</jstl:if>
</body>
</html>
