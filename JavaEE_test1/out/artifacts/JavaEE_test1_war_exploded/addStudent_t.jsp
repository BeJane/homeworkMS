<%@ page import="com.java.code.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.code.jdbc.StudentJdbc" %>
<%--
  Created by IntelliJ IDEA.
  User: wjq
  Date: 2020/3/9
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <title>作业管理系统(教师版）</title>
  </head>
  <body align="center" >
  作业管理系统(教师版)
  <br>
  <br>
添加学生

<br>


<form action="/addStudent" method="POST">
    学生学号：<input type="text" name="id">
    <br><br />
    学生姓名：<input type="text" name="name" />
    <br>
    <input type="submit" value="提交" />
    &nbsp;
    <a href="homework_t.jsp">返回</a>
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
      <%
          List<Student> list = StudentJdbc.selectAll();
          if(null == list || list.size() <= 0){
              out.print("None data");
          }else{
              for(Student stu : list){

      %>
      <tr align="center" bgcolor="white" height = "30">
          <td><%=stu.getId()%></td>
          <td><%=stu.getName()%></td>
          <td><%=stu.getCreateTime()%></td>
      </tr>
      <%
              }
          }
      %>
  </table>
  </body>
</html>
