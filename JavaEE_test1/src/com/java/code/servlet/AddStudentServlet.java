package com.java.code.servlet;

import com.java.code.jdbc.HomeworkJdbc;
import com.java.code.jdbc.StudentJdbc;
import com.java.code.model.Homework;
import com.java.code.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

/**
 * AddStudentServlet
 *
 * @author JingqiWu
 * @date 2020-3-9
 */
@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> list = StudentJdbc.selectAll();

        req.setAttribute("list", list);

        req.getRequestDispatcher("addStudent_t.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student stu = new Student();
        String message;
        /*浏览器提交的数据在提交给服务器之前设置编码方式为UTF-8*/
        req.setCharacterEncoding("UTF-8");
        // 赋值
        stu.setId(Long.parseLong(req.getParameter("id")));
        stu.setName(req.getParameter("name"));
        if(StudentJdbc.addStudent(stu)){
            message="提交成功";
        }else{
            message="提交失败";
        }

        req.getSession().setAttribute("message", message);
        resp.sendRedirect("addStudent_t.jsp");
    }
}
