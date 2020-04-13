<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: wjq
  Date: 2020/3/9
--%>
<html>
  <head>
      <title>作业管理系统(教师版）</title>
      <link rel="stylesheet" href="css/demo.css" type="text/css" media="all" />
  </head>
  <body align="center" >
  作业管理系统(教师版)
  <br>
  <br>
添加学生
  &nbsp;

  <a href="teacher">返回</a>
<br>
<form action="addStudent" method="POST">
    <p class="studentId">
    <label>学生学号</label>
    <input type="text" name="id">
    </p>
    <p class="name">
        <label>学生姓名</label>
        <input type="text" name="name" />
    </p>
   <p class="submit">
       <input type="submit" value="提交" />
      </p>
</form>
<br>
  学生名单
  <br><br>
  <table align="center" width="960" border="1"
         bgcolor="black"  cellpadding="1" cellspacing="1">
      <tr align = "center" bgcolor="#7fffd4" height="50">

          <td>学号</td>
          <td>姓名</td>
          <td>创建时间</td>
      </tr>

      <c:forEach var="student" items="${list}" >

          <tr align="center" bgcolor="white" height = "30">
              <td>${student.get(id)}</td>
              <td>${student.get(name)}</td>

              <td>${student.get(time)}</td>
          </tr>


      </c:forEach>

  </table>
  </body>
</html>
