<%@ page import="com.java.code.model.StudentHomework" %>
<%@ page import="java.util.List" %>
<%@ page import="com.java.code.jdbc.StudentHomeworkJdbc" %>

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
&nbsp;
<br>
<br>
学生作业列表
&nbsp;&nbsp;
<a href="homework_t.jsp">返回</a>
<br/>
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
    <%
        List<StudentHomework> list = (List<StudentHomework>) request.getAttribute("list");
        if(null == list || list.size() <= 0){
            out.print("None data.");
        }else {
            for (StudentHomework sh : list){
    %>
    <tr align="center" bgcolor="white" height="30">
        <td><%=sh.getId()%></td>
        <td><%=sh.getStudentId()%></td>
        <td><%=sh.getHomeworkId()%></td>
        <td><%=sh.getHomeworkTitle()%></td>
        <td><%=sh.getHomeworkContent()%></td>
        <td><%=sh.getCreateTime()%></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>
