<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/15
  Time: 9:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
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

        if(formx.rpassword.value == "") {
            alert("确认密码不能为空!");
            return false;
        } else {
            if(formx.rpassword.value != formx.password.value) {
                alert("两次密码输入不一致!");
                return false;
            }
        }

        if(formx.gender.value == "") {
            alert("性别不能为空!");
            return false;
        }

        var filter  = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        if(!filter.test(formx.email.value)) {
            alert("请输入正确的邮箱格式!");
            return false;
        }

    }
</script>

<body>
    <form action="register" method="post" onsubmit="return validate_form(this)">
        <table align="center">

            <tr><td><h3>会员注册</h3></td></tr>

            <tr><td>
                <label for="userCode">登录账号:</label>
                <input type="text" id="userCode" name="userCode"/><font color="red"> *</font>
            </td></tr>

            <tr><td>
                <label for="password">密&nbsp;&nbsp;码:</label>
                <input type="text" id="password" name="password"/><font color="red"> *</font>
            </td></tr>

            <tr><td>
                <label for="rpassword">确认密码:</label>
                <input type="text" id="rpassword" name="rpassword"/><font color="red"> *</font>
            </td></tr>

            <tr><td>
                <label for="gender">性&nbsp;&nbsp;别:</label>
                <select id="gender" name="gender">
                    <option value="" selected="selected">--请选择--</option>
                    <option value="男性">男性</option>
                    <option value="女性">女性</option>
                </select><font color="red"> *</font>
            </td></tr>

            <tr><td>
                <label for="email">电子邮箱:</label>
                <input type="text" id="email" name="email"/>
            </td></tr>

            <tr><td>
                <input type="submit" value="注册"/>
                <input type="button" value="返回" onclick="javascript:history.go(-1)"/>
            </td></tr>
        </table>
    </form>
</body>
</html>
