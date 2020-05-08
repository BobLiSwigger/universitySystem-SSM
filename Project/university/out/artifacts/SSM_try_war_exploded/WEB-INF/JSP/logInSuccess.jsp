<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.ContextLoader" %>
<%@ page import="POJOs.Card" %><%--
  Created by IntelliJ IDEA.
  User: 26552
  Date: 2019/12/21
  Time: 0:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎!${username}</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">返回首页</a>
<a href="enterConsume.form">模拟消费</a>
<br/><br/><br/>
<h1>欢迎回来，${username}！</h1>
<p>您的卡号：${phonenumber}</p>
<p>您的套餐：${pack}</p>
<p>您的余额：${restmoney}</p>
<br/>

</body>
</html>
