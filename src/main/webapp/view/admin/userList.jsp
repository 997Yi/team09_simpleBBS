<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>simpleBBS - 用户列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css"  media="all">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">simpleBBS 简易博客</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/index.jsp">主页</a></li>
            <li class="layui-nav-item"><a href="${pageContext.request.contextPath}/view/quintessenceBlogs.jsp">精华帖</a></li>
            <li class="layui-nav-item layui-this"><a href="#">用户列表</a></li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${pageContext.request.contextPath}/image/default.png" class="layui-nav-img">
                    ${adminInfo.username}
                </a>
            </li>
            <li class="layui-nav-item"><a href="logout">退出登录</a></li>
        </ul>
    </div>

    <div style="padding:50px 20%; background-color: #f5f5f5;">
        <!-- 内容主体区域 -->
        <table class="layui-hide" id="test" lay-filter="test"></table>

        <script type="text/html" id="barDemo">
            <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
        </script>
    </div>

</div>

<script src="${pageContext.request.contextPath}/webjars/jquery/3.3.1-2/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.js" charset="UTF-8"></script>
<script>
    layui.use('table',function(){
        var element = layui.element;
        var table = layui.table;


        table.render({
            elem: '#test'
            ,url:'http://localhost:8080/team09_simpleBBS_war/admin/list'
            ,toolbar: '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
            ,defaultToolbar: ['filter']
            ,title: '用户数据表'
            ,cols: [[
                ,{field:'id', title:'ID', width:304, fixed: 'left', unresize: true, sort: true}
                ,{field:'username', title:'用户名', width:120, edit: 'text'}
                ,{field:'profile', title:'个性签名', width:711}
                ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:65}
            ]]
            ,text: {
                none: '暂无相关数据' //默认：无数据。
            }
            ,page: { //支持传入 laypage 组件的所有参数（某些参数除外，如：jump/elem） - 详见文档
                layout: ['prev', 'page', 'next', 'skip'] //自定义分页布局
                ,groups: 4 //只显示 1 个连续页码
            }
        });

        //监听行工具事件
        table.on('tool(test)', function(obj){
            var data = obj.data;
            //console.log(obj)
            if(obj.event === 'del'){
                layer.confirm('真的删除行么', function(index){
                    obj.del();
                    layer.close(index);
                    var id = data.id;
                    $.get("${pageContext.request.contextPath}/admin/del", {userId:id});
                });
            }
        });
    });
</script>
</body>
</html>

