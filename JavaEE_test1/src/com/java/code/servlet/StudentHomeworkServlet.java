package com.java.code.servlet;

import com.java.code.jdbc.StudentHomeworkJdbc;
import com.java.code.model.StudentHomework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * StudentHomeworkServlet
 *
 * @author JingqiWu
 * @date 2020/3/9
 *
 */
@WebServlet("/studentHomework")
public class StudentHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        List<StudentHomework> list;
        list = StudentHomeworkJdbc.IdSelect(id);

        req.setAttribute("list", list);

        req.getRequestDispatcher("studentHomework.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        List<StudentHomework> list = StudentHomeworkJdbc.IdSelect(id);

        req.setAttribute("list", list);

        req.getRequestDispatcher("studentHomework.jsp").forward(req, resp);
    }
}