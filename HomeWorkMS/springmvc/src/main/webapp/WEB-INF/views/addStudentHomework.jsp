<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: wjq
  Date: 2020/3/9
  Time: 21:12
  学生提交作业
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>提交作业</title>
      <link rel="stylesheet" href="css/demo.css" type="text/css" media="all" />
  </head>
  <body align="center">
  提交作业

<br><br>
<form action="/addStudentHomework" align="left" method="POST">
    <p class="homework_id">
        <label >作业编号</label>
         <input type="text" name="id" readonly value="${homework_Id}">
    </p>
    <p class="s_id">
        <label>学生学号</label>
        <input type="text" name="s_id">
    </p>

    <p class="title">
        <label>作业题目</label>
        <input type="text" name="title">
    </p>
    <p class="content">
        <label>作业内容</label>
        <textarea name="content"></textarea>
    </p>
    <p class="submit">

    <input type="submit" value="提交" />
    </p>
</form>

  </body>
</html>
