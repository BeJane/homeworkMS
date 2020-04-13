<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: wjq
  Date: 2020/3/2
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
  <head>
    <title>作业管理系统(学生版）</title>
  </head>
  <body align="center" >
作业管理系统(学生版)
&nbsp;
<a href="teacher">切换教师版</a>
<br>
<br>
作业列表
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


        <c:forEach var="entry" items="${list}" >

            <tr align="center" bgcolor="white" height = "30">
                <td>${entry.get(id)}</td>
                <td>${entry.get(title)}</td>
                <td>${entry.get(content)}</td>
                <td>${entry.get(time)}</td>
                <td><a href="addStudentHomework?id=${entry.get(id)}">提交</a></td>
            </tr>
        </c:forEach>
    </table>
  </body>
</html>
