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
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/view/postBlog.jsp">发布博客</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <jstl:if test="${userInfo == null}">
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/login.jsp">
                        点击登陆
                    </a>
                </li>
            </jstl:if>
            <jstl:if test="${userInfo != null}">
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
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/logout">退出登陆</a></li>
            </jstl:if>
        </ul>
    </div>

    <div style="padding:50px 20%; background-color: #f5f5f5;">
        <!-- 内容主体区域 -->
        <div style=" width: 100%; height: 100%; vertical-align: middle">
            <jstl:forEach items="${mapBlogs}" var="blog">
                <div class="blog-block">
                    <div class="blog-block-header">
                        <div class="blog-user">
                            <div class="blog-user-img">
                                <img src=
                                         "${pageContext.request.contextPath}/image/default.png"
                                style="width: 60%;
                                        height: auto;
                                            margin: 30% 20% 0;
                                                border-radius: 50%">

                                <!-- <jstl:if test="${blog.value.imgUrl == null}">
                                             ${pageContext.request.contextPath}"/image/default.png"
                                     </jstl:if>
                                     <jstl:if test="${blog.value.imgUrl != null}">
                                         ${blog.value.imgUrl}
                                     </jstl:if>
                                -->
                            </div>
                            <div class="blog-user-name">
                                <p>${blog.value.username}</p>
                            </div>
                        </div><div class="blog-info">
                            <div class="blog-block-title"><a href="">${blog.key.title}</a></div>
                            <div class="blog-block-keywords">${blog.key.keyWords}</div>
                        </div>
                    </div>
                    <div class="blog-block-tail">
                        <div class="blog-block-time"><i class="layui-icon layui-icon-time"></i>${blog.key.time}</div>
                        <div class="blog-block-clicks"><i class="layui-icon layui-icon-friends"></i>${blog.key.clicks}</div>

                        <jstl:if test="${blog.key.top == true}">
                            <div class="blog-block-top"><i class="layui-icon layui-icon-top"></i></div>
                        </jstl:if>
                        <jstl:if test="${blog.key.quintessence == true}">
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

