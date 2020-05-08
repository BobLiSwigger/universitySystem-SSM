<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.web.context.ContextLoader" %><%--
  Created by IntelliJ IDEA.
  User: 26552
  Date: 2019/12/18
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <h1>欢迎使用嗖嗖移动用户大厅</h1>
  <form action="logInController.form" method="POST">
    <br/>
    卡号<input type="text" name="phonenumber"/>
    <br/>
    密码<input type="password" name="password"/>
    <br/>
    <input type="submit" value="提交" onclick="this.location.reload()"/>
  </form>
  </br>
  <a href="registController.form">注册</a>
  </body>
</html>

<!--
  网上的教程多用下面这句话来获取上下文，但其实spring容器已经读取过xml文件并配置好上下文了，故下面这句话造成了二次初始化
  ApplicationContext context = new ClassPathXmlApplicationContext("../applicationContext.xml");
  应使用:
  ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
-->

