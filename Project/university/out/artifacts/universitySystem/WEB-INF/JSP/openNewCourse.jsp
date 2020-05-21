<%--
  Created by IntelliJ IDEA.
  User: BobLi
  Date: 2020/5/21
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我要开课</title>
</head>
<body>
<form action="openNewCourse.form" method="POST">
    <table>
        <tr>
            <td>
                请输入申请的课程ID
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
            <td>
                请输入学院ID
            </td>
            <td>
                <input type="text" name="deptID"/>
            </td>
        </tr>
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
</body>
</html>
