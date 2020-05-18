<%--
  Created by IntelliJ IDEA.
  User: 26552
  Date: 2019/12/21
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>欢迎注册嗖嗖用户</h1>
<form action="registUser.form" method="POST">
    请选择您的号码：<br/>
    <c:forEach items="${useableNumbers}" var="item" varStatus="present">
       卡号${present.index + 1}：<input type="radio" name="phonenumber" value="${item}" checked/>${item}<br/>
    </c:forEach>
    <br/>
    请选择您的套餐：
    <input type="radio" name="pack" value="1" checked/>1. 话痨套餐
    <input type="radio" name="pack" value="2" />2. 网虫套餐
    <input type="radio" name="pack" value="3" />3. 超级套餐
    <br/><br/>
    用户昵称：<input type="text" name="username" value="Bob" minlength="6" maxlength="22"/>
    <br/>
    用户密码：<input type="password" name="password" minlength="6" maxlength="22"/>
    <br/>
    预存金额：<input type="text" name="money" value="100"/>
    <br/>
    <input type="submit" value="提交" onclick="this.location.reload()"/>
</form>
卡号不满意?<a href="registController.form">换一批</a>
</body>
</html>
