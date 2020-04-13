<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: wjq
  Date: 2020/3/9

--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <title>作业管理系统（教师版）</title>
      <link rel="stylesheet" href="css/demo.css" type="text/css" media="all" />
  </head>
  <body align = "center">
  作业管理系统（教师版）
  <br>
  创建新作业
  <br>
  <form action="/addHomework" align="center" method="POST">
      <p class="title">
          <label >作业题目</label>
          <input type="text" name="title">
      </p>
      <p class="content">
          <label>作业内容</label>
          <textarea name="content"></textarea>
      </p>
      <p class="submit">
          <input type="submit" value="添加" />
      </p>
  </form>
  </body>
</html>
