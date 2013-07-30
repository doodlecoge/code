<%--
  Created by IntelliJ IDEA.
  User: huaiwang
  Date: 7/30/13
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div style="color: #f55; font-weight: bold;">
    this jsp file's name should not contain underscore,
    or value of model variables won't expand.
</div>

<h1>Message : ${message}</h1>

<br/>

<a href="<%= request.getContextPath()%>/act/hi/jack">hi jack</a>

</body>

</html>