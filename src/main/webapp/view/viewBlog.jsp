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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/css/viewBlog.css">
</head>
<body class="layui-layout-body" style="overflow: auto">
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
                <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/logout">退出登陆</a></li>
            </jstl:if>
        </ul>
    </div>

    <div style="padding:50px 20%; background-color: #f5f5f5;">
        <section class="post-details-area">
            <div class="container container-1000">
                <div class="post-details">
                    <div class="entry-header">
                        <h2 class="title">
                            ${requestScope.blog.title}
                        </h2>
                        <ul class="post-meta">
                            <li>${requestScope.blog.time}</li>
                            <li>${requestScope.blog.keyWords}</li>
                        </ul>
                    </div>
                    <div class="entry-content">
                        <p class="has-dropcap">
                            ${requestScope.blog.context}
                        </p>
                    </div>
                    <div class="entry-footer">
                        <div class="post-author">
                            <div class="author-img">
                                <jstl:if test="${requestScope.blogUser.imgUrl == null}">
                                    <img src= "${pageContext.request.contextPath}/image/default.png" alt="PostAuthor" style="width: 60%; height: auto; margin: 20% 20% 0; border-radius: 50%">
                                </jstl:if>
                                <jstl:if test="${requestScope.blogUser.imgUrl != null}">
                                    <img src= "${pageContext.request.contextPath}${requestScope.blogUser.imgUrl}" alt="PostAuthor" style="width: 60%; height: auto; margin: 20% 20% 0; border-radius: 50%">
                                </jstl:if>
                            </div>
                            <h5>${requestScope.blogUser.username}</h5>
                            <p>${requestScope.blogUser.profile}</p></div>
                    </div>
                </div>
                <div class="comment-template"><h4 class="template-title">${requestScope.blogComment.size()}
                    Comments</h4>
                    <ul class="comment-list">
                        <jstl:forEach items="${requestScope.blogComment}" var="comment">
                            <li>
                                <div class="comment-body">
                                    <div class="comment-author">
                                        <jstl:if test="${comment.value.imgUrl == null}">
                                            <img src= "${pageContext.request.contextPath}/image/default.png" style="width: 60%; height: auto; margin: 20% 20% 0; border-radius: 50%">
                                        </jstl:if>
                                        <jstl:if test="${comment.value.imgUrl != null}">
                                            <img src= "${pageContext.request.contextPath}${comment.value.imgUrl}" style="width: 60%; height: auto; margin: 20% 20% 0; border-radius: 50%">
                                        </jstl:if>
                                    <div class="comment-content"><h6
                                            class="comment-author">${comment.value.username}</h6>
                                        <p>${comment.key.content}</p>
                                        <div class="comment-footer"><span class="date">${comment.key.time}</span></div>
                                    </div>
                                </div>
                            </li>
                        </jstl:forEach>

                    </ul>
                    <jstl:if test="${sessionScope.userInfo != null}">
                        <h4 class="template-title">Leave your comment</h4>
                        <div class="comment-form">
                            <form action="#">
                                <div class="row">
                                    <form method="post"
                                          action="/user/PostCommentServlet?blogId=${requestScope.blog.id}">
                                        <div class="col-12"><textarea placeholder="Your message here"
                                                                      name="content"></textarea></div>
                                        <div class="col-12">
                                            <button type="submit">Post</button>
                                        </div>
                                    </form>
                                </div>
                            </form>
                        </div>
                    </jstl:if>
                </div>
            </div>
        </section>

    </div>

</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function () {
        var element = layui.element;

    });
</script>
</body>
</html>

