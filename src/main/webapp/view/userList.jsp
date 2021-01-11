<%@ page import="com.team09.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>

<jstl:if test="${userInfo.admin}">
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>用户后台管理 - 查看用户</title>
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
                    <li class="layui-nav-item layui-nav-itemed">
                        <a href="${pageContext.request.contextPath}/list">查看用户</a>
                    </li>
                    <li class="layui-nav-item">
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

        <div class="layui-body">
            <table class="layui-table" id="my_tb">

                <colgroup>
                    <col width="200">
                    <col width="200">
                    <col width="200">
                    <col width="200">
                    <col width="200">
                    <col width="200">
                </colgroup>
                <thead>
                <tr>
                    <th>用户名</th>
                    <th>年龄</th>
                    <th>性别</th>
                    <th>爱好</th>
                    <th>是否为管理员</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <jstl:forEach items="${userList}" var="user">
                        <tr>
                            <td> ${user.username}</td>
                            <td> ${user.age}</td>
                            <td> ${user.gender}</td>
                            <td> ${user.hobbies}</td>
                            <td>
                                <jstl:if test="${user.admin}">是</jstl:if>
                                <jstl:if test="${user.admin == false}">否</jstl:if>
                            </td>
                            <td>
                                <a class="layui-btn layui-btn-normal" href="modifyPre?id=${user.id}">modify</a>
                                <a class="layui-btn layui-btn-normal" href="delete?id=${user.id}">delete</a>
                            </td>
                        </tr>
                    </jstl:forEach>
                </tbody>

            </table>
            <div id="pageSelector"></div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <script>
        layui.use(['laypage'], function () {
            var laypage = layui.laypage;

            //执行一个laypage实例
            laypage.render({
                elem: 'pageSelector'
                , count: ${dataNum}  //数据总数
                , limit: 5 //每页数据条数
                , curr: ${pageNum}   //起始页面
                , groups: 3
                , prev: "<i class=\"layui-icon layui-icon-prev\"></i>"
                , next: "<i class=\"layui-icon layui-icon-next\"></i>"
                , jump: function (obj, first) {
                    //obj包含了当前分页的所有参数，比如：
                    //console.log(obj.curr);
                    //console.log(obj.limit);
                    //首次不执行
                    if (!first) {
                        window.location.href = 'list?pageNum='
                        obj.curr;
                    }
                }
            });
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
</jstl:if>

<jstl:if test="${userInfo.admin == false}">
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>用户后台管理 - 查看自己信息</title>
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
        </style>


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
                    <li class="layui-nav-item layui-nav-itemed">
                        <a href="${pageContext.request.contextPath}/list">查看我的资料</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="${pageContext.request.contextPath}/view/modifyUser.jsp">修改我的资料</a>
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
                    <col width="200">
                    <col width="200">
                    <col width="200">
                </colgroup>
                <thead>
                <tr>
                    <th>用户名</th>
                    <th>年龄</th>
                    <th>性别</th>
                    <th>爱好</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <td> ${userInfo.username}</td>
                        <td> ${userInfo.age}</td>
                        <td> ${userInfo.gender}</td>
                        <td> ${userInfo.hobbies}</td>
                    </tr>
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
</jstl:if>