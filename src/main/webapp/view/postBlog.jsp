<%--
  Created by IntelliJ IDEA.
  User: Fourteen
  Date: 2021/1/13
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>simpleBBS - 发布博客</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/blog.css">
</head>
<body class="layui-layout-body" style="overflow: auto">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">simpleBBS 简易博客</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user/listBlog">主页</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user/listQuintBlogs">精华帖</a></li>
            <li class="layui-nav-item layui-this"><a
                    href="${pageContext.request.contextPath}/view/postBlog.jsp">发布博客</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
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

    <div style="padding:50px 20%; background-color: #f5f5f5;">
        <form class="layui-form" action="${pageContext.request.contextPath}/user/postBlog" method="post">
            <div class="layui-form-item">
                <label class="layui-form-label">标题</label>
                <div class="layui-input-block">
                    <input type="text" name="title" required lay-verify="required" placeholder="请输入标题"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">关键字</label>
                <div class="layui-input-block">
                    <input type="text" name="keywords" required lay-verify="required" placeholder="请输入文章关键字"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">内容</label>
                <div class="layui-input-block">
                    <textarea name="content" placeholder="请输入内容" class="layui-textarea"></textarea>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>


    </div>

</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    //Demo
    layui.use('form', function () {
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function (data) {
        });
    });
</script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>


