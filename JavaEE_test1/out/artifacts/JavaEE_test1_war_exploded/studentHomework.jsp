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
    <link rel="stylesheet" href="css/demo.css" type="text/css" media="all" />
</head>
<body align="center" >
作业管理系统(教师版)
&nbsp;&nbsp;&nbsp;
<a href="homework_t.jsp">返回</a>
<br>
<br>
<form action="/studentHomework" align="left" method="POST">
    <p class="homework_id">
        <label >作业编号</label>
        <input type="text" name="homeworkId"  value="<%=request.getParameter("id")%>">
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
