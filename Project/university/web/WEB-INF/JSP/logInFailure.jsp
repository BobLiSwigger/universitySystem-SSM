<%--
  Created by IntelliJ IDEA.
  User: 26552
  Date: 2019/12/21
  Time: 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败！</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">返回首页</a>
<a href="enterConsume.form">模拟消费</a>
<br/><br/><br/>
<h1>${reason}</h1>
</body>
</html>
