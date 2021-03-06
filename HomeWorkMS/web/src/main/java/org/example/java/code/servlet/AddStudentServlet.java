package org.example.java.code.servlet;

import org.example.java.code.jdbc.StudentJdbc;
import org.example.java.code.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        StudentJdbc studentJdbc = new StudentJdbc();
        List<Student> list = studentJdbc.selectAll();
        studentJdbc.free();
        req.setAttribute("list", list);

        req.getRequestDispatcher("addStudent_t.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student stu = new Student();
        String message;
        StudentJdbc studentJdbc = new StudentJdbc();
        /*浏览器提交的数据在提交给服务器之前设置编码方式为UTF-8*/
        req.setCharacterEncoding("UTF-8");
        // 赋值
        stu.setId(Long.parseLong(req.getParameter("id")));
        stu.setName(req.getParameter("name"));
        if(studentJdbc.addStudent(stu)){
            message="提交成功";
        }else{
            message="提交失败";
        }

        studentJdbc.free();

        req.getSession().setAttribute("message", message);
        resp.sendRedirect("addStudent");
    }
}
