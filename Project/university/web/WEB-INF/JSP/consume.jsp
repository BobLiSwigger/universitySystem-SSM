<%--
  Created by IntelliJ IDEA.
  User: 26552
  Date: 2019/12/22
  Time: 2:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>模拟消费</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">返回首页</a>
<a href="enterConsume.form">模拟消费</a>
<br/><br/><br/>
<h1>请键入您模拟消费的数据：</h1>
<form action="consumeController.form" method="POST">
    <br/>
    通话时长<input type="text" name="talkTime" value="0"/>
    <br/>
    发短信数量：<input type="text" name="smsCount" value="0"/>
    <br/>
    上网流量：<input type="text" name="flowCount" value="0"/>
    <br/>

    <input type="submit" value="消费" onclick="this.location.reload()"/>
</form>
</body>
</html>
