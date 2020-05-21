<%--
  Created by IntelliJ IDEA.
  User: 26552
  Date: 2019/12/18
  Time: 0:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Greytit University</title>
  </head>
  <body>
  <div align="center">
  <h1>欢迎光临Greytit大学选课系统</h1>
  <p>您好！请登录</p>
  <form action="logIn.form" method="POST">
    <table>
      <tr>
        <td>
          用户ID
        </td>
        <td>
          <input type="text" name="id"/>
        </td>
      </tr>
      <tr>
        <td>
          密码
        </td>
        <td>
          <input type="password" name="password"/>
        </td>
      </tr>
    </table>
    <input type="submit" value="提交" onclick="this.location.reload()"/>
  </form>
  <p>没有账户？请联系学院辅导员注册</p>
  </div>
  </body>
</html>

<!--
  网上的教程多用下面这句话来获取上下文，但其实spring容器已经读取过xml文件并配置好上下文了，故下面这句话造成了二次初始化
  ApplicationContext context = new ClassPathXmlApplicationContext("../applicationContext.xml");
  应使用:
  ApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
-->

