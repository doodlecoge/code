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

<hr/>
this dtd works for spring mvc 3.0.5, have not test other versions
<pre>
    <web-app id="WebApp_ID" version="2.4"
             xmlns="http://java.sun.com/xml/ns/j2ee"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
	http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd"></web-app>
</pre>

</body>

</html>