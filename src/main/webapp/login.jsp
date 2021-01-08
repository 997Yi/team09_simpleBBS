<%--
  Created by IntelliJ IDEA.
  User: LLY
  Date: 2021/1/8
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
<form action="login" method="post">
    用户名：<input type="text" name="username" value="${cookie.user.name}"><br>
    密码：<input type="password" name="password" value="${cookie.user.password}"><br>
    验证码<input type="text" name="inputCode"><img src="validCode" width="100" height="24"><br>
    保存密码<input type="checkbox" name="savePwd" value="saved"><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
    <a href="register.jsp">注册</a>
</form>

</body>
</html>
