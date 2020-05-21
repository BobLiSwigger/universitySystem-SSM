
<%--
  Created by IntelliJ IDEA.
  User: BobLi
  Date: 2020/5/19
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--引入jstl支持-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我修的课</title>
</head>
<body>
<div align="center">
<form action="dropOutClass.form" method="POST">

    <table border="1">
        <tr>
            <td>序号</td>
            <td>课程ID</td>
            <td>班号</td>
            <td>课程名称</td>
            <td>所属学院</td>
            <td>开课年份</td>
            <td>开课学期</td>
            <td>课程学分</td>
            <td>最大人数</td>
            <td>已选人数</td>
        </tr>
        <c:forEach items="${takenClasses}" var="itemClass" varStatus="present">
            <tr>
                <td>${present.index + 1}</td>
                <td>${itemClass.courseID}</td>
                <td>${itemClass.classID}</td>
                <td>${itemClass.courseName}</td>
                <td>${itemClass.dept.name}</td>
                <td>${itemClass.year}</td>
                <td><c:if test="${itemClass.term == false}">春季</c:if><c:if test="${itemClass.term == true}">秋季</c:if></td>
                <td>${itemClass.credit}</td>
                <td>${itemClass.maxSize}</td>
                <td>${itemClass.size}</td>
                <td><input name="chosenClass" value="${itemClass.classID}" type="checkbox"/></td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <input type="submit" value="退课" onclick="this.location.reload()"/>
</form>
</div>
</body>
</html>
