<%--
  Created by IntelliJ IDEA.
  User: LLY
  Date: 2021/1/8
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<h1>注册</h1>
<form action="register" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    性别:<input type="radio" name="sex" value="男" checked>男
    <input type="radio" name="sex" value="女">女<br>
    年龄<select name="age">
    <option selected="selected">00后</option>
    <option >90后</option>
    <option>80后</option>
    <option>70后</option>
    <option>其他</option>
</select>
    <input type= "submit" value= "注册" >
    <input type= "reset" value= "重置" >
</form>
</body>
</html>
