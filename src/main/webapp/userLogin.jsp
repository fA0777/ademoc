<%--
  Created by IntelliJ IDEA.
  User: FALL
  Date: 2024/2/11
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>userLogin</title>
</head>
<body>
<h1>用户登录</h1>
<form action="/ademoc/user/login" method="post">
    <label for="name">用户名：</label>
    <input type="text" id="name" name="name" value="${cookie.name.value}">
    <br>
    <br>
    <label for="password">密码：</label>
    <input type="password" id="password" name="password" value="${cookie.password.value}">
    <br>
    <p>Remember:<input id="remember" name="remember" value="1" type="checkbox"></p>
    <br>
    <input type="submit" id="submit" value="登录">
    <input type="reset" id="reset" value="重置"> <a href="managerLogin.jsp">管理员登录</a> <a href="userRegister.jsp">没有账号？</a>
    <br>
    <div id="err_msg" style="color: red">${login_msg}${register_msg}</div>
</form>

</body>
</html>