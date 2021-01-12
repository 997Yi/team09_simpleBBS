<%--
  Created by IntelliJ IDEA.
  User: xxx_
  Date: 2021/1/9
  Time: 2:50 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>simpleBBS - 首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/blog.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">simpleBBS 简易博客</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item  layui-this"><a href="user/listBlog">主页</a></li>
            <li class="layui-nav-item"><a href="">精华帖</a></li>
            <li class="layui-nav-item"><a href="view/postBlog.jsp">发布博客</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <jstl:if test="${userInfo == null}">
                <li class="layui-nav-item">
                    <a href="login.jsp">
                        点击登陆
                    </a>
                </li>
            </jstl:if>
            <jstl:if test="${userInfo != null}">
                <li class="layui-nav-item">
                    <a href="javascript:;">
                        <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                        ${userInfo.username}
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="">修改信息</a></dd>
                        <dd><a href="">查看我的博客</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="logout">退出登陆</a></li>
            </jstl:if>
        </ul>
    </div>

    <div style="padding:50px 20%; background-color: #f5f5f5;">
        <!-- 内容主体区域 -->
        <div style=" width: 100%; height: 100%;">
            <jstl:forEach items="${blogs}" var="blog">
                <div class="blog-block">
                    <div class="blog-block-header">
                        <div class="blog-block-title"><a href="">${blog.title}</a></div>
                        <div class="blog-block-keywords">${blog.keyWords}</div>
                    </div>
                    <div class="blog-block-tail">
                        <div class="blog-block-time"><i class="layui-icon layui-icon-time"></i>${blog.time}</div>
                        <div class="blog-block-clicks"><i class="layui-icon layui-icon-friends"></i>${blog.clicks}</div>

                        <jstl:if test="${blog.top == true}">
                            <div class="blog-block-top"><i class="layui-icon layui-icon-top"></i></div>
                        </jstl:if>
                        <jstl:if test="${blog.quintessence == true}">
                            <div class="blog-block-quintessence"><i class="layui-icon layui-icon-rate-solid"></i></div>
                        </jstl:if>
                    </div>
                </div>
            </jstl:forEach>
        </div>
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
</body>
</html>

