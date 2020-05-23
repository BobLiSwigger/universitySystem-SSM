<%--
  Created by IntelliJ IDEA.
  User: BobLi
  Date: 2020/5/21
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--引入jstl支持-->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>我要开课</title>
</head>
<body>
<div align="center">
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
            <c:forEach items="${teachClasses}" var="itemClass" varStatus="present">
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
                </tr>
            </c:forEach>
        </table>
        <br/>
    <p>我要开课</p>
<form action="openNewCourse.form" method="POST">
    <table>
        <tr>
            <td>
                请输入申请的课程ID(四位数字)
            </td>
            <td>
                <input type="text" name="courseID"/>
            </td>
        </tr>
        <tr>
            <td>
                请输入课程名称
            </td>
            <td>
                <input type="text" name="name"/>
            </td>
        </tr>
        <tr>
            <td>
                请输入课程描述
            </td>
            <td>
                <input type="text" name="courseDescription"/>
            </td>
        </tr>
        <tr>
            <td>请选择学院</td>
        </tr>
        <c:forEach items="${depts}" var="item" varStatus="present">
            <tr>
                <td>${item.name}</td>
                <td><input name="deptID" value="${item.deptID}" type="radio"/></td>
            </tr>
        </c:forEach>
        <tr>
            <td>
                请输入课程学分
            </td>
            <td>
                <input type="number" name="credit"/>
            </td>
        </tr>
    </table>
    <input type="submit" value="提交" onclick="this.location.reload()"/>
</form>
</div>
</body>
</html>
