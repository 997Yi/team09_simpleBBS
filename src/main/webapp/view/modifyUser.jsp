<%@ page import="cdu.lj.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">


<jstl:if test="${userInfo.admin}">

        <title>用户后台管理 - 修改用户</title>
    </head>
    <body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <div class="layui-logo">用户后台管理界面</div>
            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">欢迎您： ${userInfo.username}</li>
                <li class="layui-nav-item"><a href="logout">注销</a></li>
            </ul>
        </div>

        <div class="layui-side layui-bg-black">
            <div class="layui-side-scroll">
                <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                    <li class="layui-nav-item">
                        <a href="${pageContext.request.contextPath}/list">查看用户</a>
                    </li>
                    <li class="layui-nav-item layui-nav-itemed">
                        <a href="${pageContext.request.contextPath}/modifyPre">修改用户</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="${pageContext.request.contextPath}/view/addUser.jsp">添加用户</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="${pageContext.request.contextPath}/view/online.jsp">查看在线用户</a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="layui-body" style="margin: 150px 200px 0 200px">
            <form class="layui-form" action="modify" method="post">
                <input type="hidden" name="id" value="${user.id}">
                <div class="layui-form-item">
                    <label class="layui-form-label">账号</label>
                    <div class="layui-input-block">
                        <input type="text" name="username" required lay-verify="required" placeholder="请输入用户账号"
                               autocomplete="off" class="layui-input" value="${user.username}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" required lay-verify="required" placeholder="请输入用户密码"
                               autocomplete="off" class="layui-input" value="${user.password}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">年龄</label>
                    <div class="layui-input-block">
                        <select name="age" lay-verify="required">
                            <option value="${user.age}">${user.age}岁</option>
                            <jstl:forEach begin="0" end="120" step="1" var="age">
                                <option value="${age}">${age}岁</option>
                            </jstl:forEach>
                        </select>
                    </div>

                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">爱好</label>
                    <div class="layui-input-block">
                        <input type="checkbox" name="hobby1" title="运动" value="运动" <jstl:if test="${fun:contains(user.hobbies, '运动')}">checked</jstl:if>>
                        <input type="checkbox" name="hobby1" title="阅读" value="阅读" <jstl:if test="${fun:contains(user.hobbies, '阅读')}">checked</jstl:if>>
                        <input type="checkbox" name="hobby1" title="发呆" value="发呆" <jstl:if test="${fun:contains(user.hobbies, '发呆')}">checked</jstl:if>>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                        <jstl:if test="${userInfo.gender == '男'}">
                            checked
                        </jstl:if>
                        >

                        <input type="radio" name="gender" value="女" title="女"
                        <jstl:if test="${userInfo.gender == '女'}">
                               checked
                        </jstl:if>
                        >
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">管理员</label>
                    <div class="layui-input-block">
                        <jstl:if test="${user.admin}">
                            <input type="checkbox" name="admin" lay-skin="switch" checked>
                        </jstl:if>
                        <jstl:if test="${user.admin == false}">
                            <input type="checkbox" name="admin" lay-skin="switch">
                        </jstl:if>
                    </div>
                </div>
</jstl:if>

<jstl:if test="${userInfo.admin == false}">
        <title>用户后台管理 - 修改自己信息</title>
    </head>
    <body class="layui-layout-body">
    <div class="layui-layout layui-layout-admin">
        <div class="layui-header">
            <div class="layui-logo">用户界面</div>

            <ul class="layui-nav layui-layout-right">
                <li class="layui-nav-item">欢迎您： ${userInfo.username}</li>
                <li class="layui-nav-item"><a href="logout">注销</a></li>
            </ul>
        </div>

        <div class="layui-side layui-bg-black">
            <div class="layui-side-scroll">
                <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
                <ul class="layui-nav layui-nav-tree" lay-filter="test">
                    <li class="layui-nav-item">
                        <a href="${pageContext.request.contextPath}/list">查看我的资料</a>
                    </li>
                    <li class="layui-nav-item layui-nav-itemed">
                        <a href="${pageContext.request.contextPath}/view/modifyUser.jsp">修改我的资料</a>
                    </li>
                </ul>
            </div>
        </div>

        <div class="layui-body" style="margin: 150px 200px 0 200px">
            <form class="layui-form" action="${pageContext.request.contextPath}/modify" method="post">
                <input type="hidden" name="id" value="${userInfo.id}">
                <div class="layui-form-item">
                    <label class="layui-form-label">账号</label>
                    <div class="layui-input-block">
                        <input type="text" name="username" required lay-verify="required" placeholder="请输入用户账号"
                               autocomplete="off" class="layui-input" value="${userInfo.username}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">密码</label>
                    <div class="layui-input-inline">
                        <input type="password" name="password" required lay-verify="required" placeholder="请输入用户密码"
                               autocomplete="off" class="layui-input" value="${userInfo.password}">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">年龄</label>
                    <div class="layui-input-block">
                        <select name="age" lay-verify="required">
                            <option value="${userInfo.age}">${userInfo.age}岁</option>
                            <jstl:forEach begin="0" end="120" step="1" var="age">
                                <option value="${age}">${age}岁</option>
                            </jstl:forEach>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">爱好</label>
                    <div class="layui-input-block">
                        <input type="checkbox" name="hobby1" title="运动" value="运动" <jstl:if test="${fun:contains(userInfo.hobbies, '运动')}">checked</jstl:if>>
                        <input type="checkbox" name="hobby1" title="阅读" value="阅读" <jstl:if test="${fun:contains(userInfo.hobbies, '阅读')}">checked</jstl:if>>
                        <input type="checkbox" name="hobby1" title="发呆" value="发呆" <jstl:if test="${fun:contains(userInfo.hobbies, '发呆')}">checked</jstl:if>>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">性别</label>
                    <div class="layui-input-block">
                        <input type="radio" name="gender" value="男" title="男"
                        <jstl:if test="${userInfo.gender == '男'}">
                             checked
                        </jstl:if>
                        >

                        <input type="radio" name="gender" value="女" title="女"
                        <jstl:if test="${userInfo.gender == '女'}">
                            checked
                        </jstl:if>
                        >
                    </div>
                </div>
</jstl:if>

                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit lay-filter="formDemo">提交修改</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    layui.use('form', function () {
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