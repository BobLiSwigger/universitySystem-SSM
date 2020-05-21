<%--
  Created by IntelliJ IDEA.
  User: BobLi
  Date: 2020/5/18
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--引入jstl支持-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>您好！${student.name}</title>
</head>
<body>
<div align="center">

    <form action="${pageContext.request.contextPath}/goto.form" method="get">
        <input name="url" value="选课" type="submit" onclick="this.location.reload()"/>
    </form>
    <form action="${pageContext.request.contextPath}/goto.form" method="get">
        <input name="url" value="我修的课程" type="submit" onclick="this.location.reload()"/>
    </form>


    <h1>欢迎回到学生信息系统，${student.name}。</h1>
    <table>
        <tr>
            <td>学号</td>
            <td>${student.id}</td>
        </tr>
        <tr>
            <td>学院</td>
            <td>${student.dept}</td>
        </tr>
        <tr>
            <td>性别</td>
            <td><c:if test="${student.sex == false}">男</c:if><c:if test="${student.sex == true}">女</c:if></td>
        </tr>
        <tr>
            <td>邮箱</td>
            <td>${student.email}</td>
        </tr>
        <tr>
            <td>我的学分</td>
            <td>${student.credit}</td>
        </tr>
    </table>
</div>
</body>
</html>
