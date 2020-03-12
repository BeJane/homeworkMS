
<%--
  Created by IntelliJ IDEA.
  User: wjq
  Date: 2020/3/9

--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>作业管理系统（教师版）</title>
  </head>
  <body align = "center">
  作业管理系统（教师版）
  <br>
  创建新作业

<br><br>
<form action="/addHomework" method="POST">

    作业题目：<input type="text" name="title">
    <br /><br />
    作业内容：<input type="text" name="content" />
    <br><br>
    <input type="submit" value="提交" />
</form>
  </body>
</html>
