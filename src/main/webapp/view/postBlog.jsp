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
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">simpleBBS 简易博客</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user/listBlog">主页</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/user/listQuintBlogs">精华帖</a></li>
            <li class="layui-nav-item layui-this"><a href="${pageContext.request.contextPath}/view/postBlog.jsp">发布博客</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src=
                         <jstl:if test="${userInfo.imgUrl == null}">
                             ${pageContext.request.contextPath}"/image/default.png"
                         </jstl:if>
                         <jstl:if test="${userInfo.imgUrl != null}">
                             ${userInfo.imgUrl}
                         </jstl:if>

                                 class="layui-nav-img">
                        ${userInfo.username}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">修改信息</a></dd>
                    <dd><a href="">查看我的博客</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="logout">退出登陆</a></li>
        </ul>
    </div>

    <div style="padding:50px 20%; background-color: #f5f5f5;">
        <!-- 内容主体区域 -->
        
    </div>

</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>

