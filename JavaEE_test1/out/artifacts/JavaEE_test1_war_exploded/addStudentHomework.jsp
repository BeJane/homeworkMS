
<%--
  Created by IntelliJ IDEA.
  User: wjq
  Date: 2020/3/9
  Time: 21:12
  学生提交作业
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>提交作业</title>
  </head>
  <body align="center">
  提交作业

<br>
<form action="/addStudentHomework" method="POST">
    学生学号：<input type="text" name="s_id">
    <br />
    作业编号: <input type="text" name="id" readonly value="<%=request.getParameter("id")%>">
    <br />

    作业题目：<input type="text" name="title">
    <br />

    作业内容：<input type="text" name="content" size="60"/>
    <input type="submit" value="提交" />
</form>
  </body>
</html>
