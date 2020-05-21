<%--
  Created by IntelliJ IDEA.
  User: BobLi
  Date: 2020/5/18
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--引入jstl支持-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>您好！${teacher.name}</title>
</head>
<body>
<div align="center">
<h1>欢迎回到学生信息系统，${teacher.name}。</h1>
<table>
    <tr>
        <td>教师编号</td>
        <td>${teacher.id}</td>
    </tr>
    <tr>
        <td>学院</td>
        <td>${teacher.dept}</td>
    </tr>
    <tr>
        <td>性别</td>
        <td><c:if test="${teacher.sex == false}">男</c:if><c:if test="${teacher.sex == true}">女</c:if></td>
    </tr>
    <tr>
        <td>邮箱</td>
        <td>${teacher.email}</td>
    </tr>
    <tr>
        <td>我的等级</td>
        <td>${teacher.level}</td>
    </tr>
    <tr>
        <td>我的薪资</td>
        <td>${teacher.salary}</td>
    </tr>
    <tr>
        <td></td>
    </tr>
</table>
</div>
</body>
</html>
