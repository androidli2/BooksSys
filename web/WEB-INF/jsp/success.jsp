<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/8/15
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册成功</title>
</head>

<script type="text/javascript">
    function loginSuccess() {
        if(confirm("恭喜您，会员${u.userCode}注册成功！是否立刻登录?")) {
            document.write("<form action='login' method='post' name='formx1' style='display:none'>");
            document.write("<input type='hidden' name='userCode' value='${u.userCode}'/>");
            document.write("<input type='hidden' name='password' value='${u.password}'/>");
            document.write("</form>");
            document.formx1.submit();
        } else {
            window.location.href = "login";
        }
    }
</script>

<body onload="loginSuccess()">

</body>
</html>
