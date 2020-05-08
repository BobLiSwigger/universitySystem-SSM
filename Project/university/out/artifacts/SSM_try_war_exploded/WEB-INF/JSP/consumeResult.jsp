<%--
  Created by IntelliJ IDEA.
  User: 26552
  Date: 2019/12/22
  Time: 3:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>消费结果</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/index.jsp">返回首页</a>
<a href="enterConsume.form">模拟消费</a>
<br/><br/><br/>
<h1>${result}</h1>
<p>您的卡号：${logInUser.phonenumber}</p>
<p>您的套餐：${logInUser.pack}号套餐(1.话痨套餐2.网虫套餐3.超级套餐)</p>
<p>您的余额：${logInUser.restmoney}</p>
<p>套餐内通话时长剩余：${restTalkTime}分钟</p>
<p>套餐内短信剩余：${restSmsCount}条</p>
<p>套餐内流量剩余：${restFlowCount}</p>
</body>
</html>
