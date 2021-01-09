<%@ page import="cdu.lj.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>用户后台管理 - 查看在线用户</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <style>
        #my_tb {
            width: 1200px;
            margin: 100px auto;
            text-align: center
        }

        #my_tb th {
            text-align: center;
        }

        #pageSelector {
            text-align: center;
        }
    </style>


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
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/modify">修改用户</a>
                </li>
                <li class="layui-nav-item">
                    <a href="${pageContext.request.contextPath}/view/addUser.jsp">添加用户</a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a href="${pageContext.request.contextPath}/view/online.jsp">查看在线用户</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <table class="layui-table" id="my_tb">

            <colgroup>
                <col width="200">
                <col width="200">
                <col width="200">
            </colgroup>
            <thead>
            <tr>
                <th>用户id</th>
                <th>用户名</th>
                <th>登陆时间</th>
            </tr>
            </thead>
            <tbody>
                <jstl:forEach items="${onlineList}" var="map">
                    <tr>
                        <td> ${map.key.id}</td>
                        <td> ${map.key.username}</td>
                        <td> ${map.value}</td>
                    </tr>
                </jstl:forEach>
            </tbody>

        </table>
    </div>
</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    layui.use(['laypage'], function () {
        var laypage = layui.laypage;


    })
</script>
<jstl:if test="${msg != null}">
    <script>
        alert("${msg}");
    </script>
    <% session.setAttribute("msg", null); %>
</jstl:if>
</body>
</html>