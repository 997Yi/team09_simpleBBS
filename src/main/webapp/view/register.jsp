<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/layui/css/layui.css">
</head>
<body>
<div style="width: 100%; margin-top: 50px; text-align:center">
    <div class="layui-input-block" style="border: #2D93CA 2px solid; width: 50%; margin: 150px auto; padding: 30px 0 10px 0;">
        <h2 style="text-align: center; margin-bottom: 30px">注册页面</h2>
        <form class="layui-form" action="${pageContext.request.contextPath}/register" method="post" style="width: 80%; margin: 0 auto">
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
                    <div class="layui-input-block" style="margin-left: 0px;">
                        <select name="age" lay-verify="required" >
                            <option value="">请选择年龄</option>
                            <jstl:forEach begin="0" end="120" step="1" var="age">
                                <option value="${age}">${age}岁</option>
                            </jstl:forEach>

                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin: 0px;">
                        <input type="text" name="validCode" required lay-verify="required" placeholder="输入验证码" autocomplete="off" class="layui-input" style="width: 60%; margin:0; display:inline-block;"
                        ><img src="${pageContext.request.contextPath}/validCode" style="height: auto; width: 30%; margin-left: 10%;">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin-left: 0px;">
                        <input type="checkbox" name="hobby1" title="运动" value="运动">
                        <input type="checkbox" name="hobby2" title="阅读" value="阅读">
                        <input type="checkbox" name="hobby3" title="发呆" value="发呆">
                    </div>
                </div>

                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin-left: 0px;">
                        <input type="radio" name="gender" value="男" title="男">
                        <input type="radio" name="gender" value="女" title="女" checked>
                    </div>
                </div>

            </div>
            <div style="margin: 0 auto; width: 40%" >
                <div class="layui-form-item">
                </div>
                <div class="layui-input-block" style="margin-left: 0px">
                    <button class="layui-btn" lay-submit lay-filter="formDemo">注册</button>
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