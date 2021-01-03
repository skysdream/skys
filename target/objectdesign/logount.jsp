<%--
  Created by IntelliJ IDEA.
  User: awen
  Date: 2021/1/2
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>退出</title>
</head>
<body>
    <%
        session.invalidate();
    %>
    <span><a href="login.html">您已成功退出系统，点我返回登录页面</a></span>
</body>
</html>
