<%--
  Created by IntelliJ IDEA.
  User: FALL
  Date: 2024/1/28
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
</head>
<body>
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="userLogin.jsp">登录</a>

    <form id="reg-form" action="/ademoc/user/register" method="post">

        <table>

            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="name" type="text" id="name">
                    <br>
                    <span id="name_err" class="err_msg">${register_msg}</span>
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码应为7位数字、大小写字母、下划线的组合</span>
                </td>
            </tr>


            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img id="checkCodeImg" src="/ademoc/checkCodeServlet">
                    <a href="#" id="changeImg">看不清？</a>
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>

<script>
    document.getElementById("changeImg").onclick=function (){
        document.getElementById("checkCodeImg").src="/ademoc/checkCodeServlet?"+new Date().getMilliseconds();
    }
    //验证密码是否符合要求
    //获取密码输入框
    var passwordInput=document.getElementById("password");
    //绑定onblur事件
    passwordInput.onblur=function (){
        //获取用户输入的密码
        var password = passwordInput.value.trim();
        //判断密码是否符合要求
        var passwordReg=/^\w{7}$/
        let b = passwordReg.test(password);
        if (b){
            //符合要求
            document.getElementById("password_err").style.display="none";
        }else{
            //不符合要求
            document.getElementById("password_err").style.display="";
        }
    }

</script>
</body>
</html>