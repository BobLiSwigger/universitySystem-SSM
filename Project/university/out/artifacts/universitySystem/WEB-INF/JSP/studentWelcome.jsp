<%--
  Created by IntelliJ IDEA.
  User: BobLi
  Date: 2020/5/18
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>您好！${name}</title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/goto.form" method="get">
        <input name="url" value="选课" type="submit" onclick="this.location.reload()"/>
    </form>
    <form action="${pageContext.request.contextPath}/goto.form" method="get">
        <input name="url" value="我修的课程" type="submit" onclick="this.location.reload()"/>
    </form>


    <h1>欢迎回到学生信息系统，${name}。</h1>

</body>
</html>
