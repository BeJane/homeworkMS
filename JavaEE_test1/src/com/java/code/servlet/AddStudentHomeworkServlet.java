package com.java.code.servlet;

import com.java.code.jdbc.StudentHomeworkJdbc;
import com.java.code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * AddStudentHomeworkServlet
 *
 * @author JingqiWu
 * @date 2020-3-9
 */
@WebServlet("/addStudentHomework")
public class AddStudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("addStudentHomework.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StudentHomework sh = new StudentHomework();
        String message;
        StudentHomeworkJdbc studentHomeworkJdbc = new StudentHomeworkJdbc();
        /*浏览器提交的数据在提交给服务器之前设置编码方式为UTF-8*/
        req.setCharacterEncoding("UTF-8");
        // 赋值
        sh.setHomeworkId(Long.parseLong(req.getParameter("id")));
        sh.setStudentId(Long.parseLong(req.getParameter("s_id")));
        sh.setHomeworkTitle(req.getParameter("title"));
        sh.setHomeworkContent(req.getParameter("content"));
        if(studentHomeworkJdbc.addStudentHomework(sh)){
            message ="提交成功";
        }else {
            message="提交失败";
        }
        studentHomeworkJdbc.free();
        req.getSession().setAttribute("message", message);
        resp.sendRedirect("homework");
    }
}
