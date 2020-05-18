<%--
  Created by IntelliJ IDEA.
  User: BobLi
  Date: 2020/5/18
  Time: 21:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选课系统</title>
</head>
<body>
<form action="chooseClass.form" method="POST">
    请选择课程：<br/>
    <c:forEach items="${availableClasses}" var="itemClass" varStatus="present">
        卡号${present.index + 1}：<input type="radio" name="chosenClass" value="${itemClass}" checked/>${itemClass}<br/>
    </c:forEach>
    <br/>
    <br/>
    <input type="submit" value="提交" onclick="this.location.reload()"/>
</form>
</body>
</html>
