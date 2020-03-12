
<%@ page import="java.util.List" %>
<%@ page import="com.java.code.model.Homework" %>
<%@ page import="com.java.code.jdbc.HomeworkJdbc" %><%--
  Created by IntelliJ IDEA.
  User: wjq
  Date: 2020/3/2
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
  <head>
    <title>作业管理系统(教师版）</title>
  </head>
  <body align="center" >
作业管理系统(教师版)
&nbsp;&nbsp;
<a href="homework">切换学生版</a>
<br>
<br>

<a href="addHomework">添加作业</a>
&nbsp;
<a href="addStudent">添加学生</a>
<br>
<br>
    <table align="center" width="960" border="1"
           bgcolor="black"  cellpadding="1" cellspacing="1">
        <tr align = "center" bgcolor="#7fffd4" height="50">

            <td>作业编号</td>
            <td>作业标题</td>
            <td>作业内容</td>
            <td>创建时间</td>
            <td>操作</td>
        </tr>
        <%
            List<Homework> list = HomeworkJdbc.selectAll();
            if(null == list || list.size() <= 0){
                out.print("None data");
            }else{
                for(Homework hw : list){

        %>
        <tr align="center" bgcolor="white" height = "30">
            <td><%=hw.getId()%></td>
            <td><%=hw.getTitle()%></td>
            <td><%=hw.getContent()%></td>
            <td><%=hw.getCreateTime()%></td>
            <td><a href="studentHomework?id=<%=hw.getId()%>">查看</a></td>

        </tr>
        <%
                }
            }
        %>
    </table>
  </body>
</html>
