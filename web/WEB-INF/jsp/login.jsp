<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/15
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<script type="text/javascript">
    function validate_form(formx) {
        if(formx.userCode.value == "") {
            alert("登录账号不能为空!");
            return false;
        } else {
            if(formx.userCode.value.length > 25) {
                alert("登录账号最大长度为25位!");
                return false;
            }
        }

        if(formx.password.value == "") {
            alert("密码不能为空!");
            return false;
        } else {
            if(formx.password.value.length < 6) {
                alert("密码长度不能低于6位!");
                return false;
            }
        }

    }
</script>
<body>
    <form action="login" method="post" onsubmit="return validate_form(this)">
        <table align="center">
            <tr>
                <td align="left"><h2>图书借阅系统</h2></td>
            </tr>
            <tr>
                <td>
                    <label for="userCode">登录账号:</label>
                    <input type="text" id="userCode" name="userCode"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label for="password">登录密码:</label>
                    <input type="password" id="password" name="password"/>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="登录|login">
                    <input type="button" value="注册用户" onclick="window.location.href='register'">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
