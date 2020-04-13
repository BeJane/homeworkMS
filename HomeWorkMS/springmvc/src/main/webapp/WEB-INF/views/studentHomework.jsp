<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: wjq
  Date: 2020/3/9 java
  Update: 2020/4/13 EL
--%>
<html>
<head>
    <title>作业管理系统(教师版）</title>
    <link rel="stylesheet" href="css/demo.css" type="text/css" media="all" />
</head>
<body align="center" >
作业管理系统(教师版)
&nbsp;&nbsp;&nbsp;
<a href="teacher">返回</a>
<br>
<br>
<form action="searchStudentHomework" align="left" method="POST">
    <p class="homework_id">
        <label >作业编号</label>
        <input type="text" name="homeworkId"  value="${homework_Id}">
    </p>
    <p class="s_id">
        <label>学生学号</label>
        <input type="text" name="studentId">
    </p>
    <p class="submit">
        <input type="submit" value="查询" />
    </p>
</form>
<br><br>
学生作业列表

<br> <br/>
<table align="center" width="960" border="1"
       bgcolor="black" cellpadding="1" cellspacing="1">
    <tr align="center" bgcolor="#7fffd4" height="50">
        <td>ID</td>
        <td>学生学号</td>
        <td>作业编号</td>
        <td>作业标题</td>
        <td>作业内容</td>
        <td>创建时间</td>
    </tr>
    <c:forEach var="entry" items="${list}" >
        <tr align="center" bgcolor="white" height = "30">

            <td>${entry.get(id)}</td>
            <td>${entry.get(student_id)}</td>
            <td>${homework_Id}</td>
            <td>${entry.get(title)}</td>
            <td>${entry.get(content)}</td>
            <td>${entry.get(time)}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
