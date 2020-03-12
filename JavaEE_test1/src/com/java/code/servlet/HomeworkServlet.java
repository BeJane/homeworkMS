package com.java.code.servlet;

import com.java.code.jdbc.HomeworkJdbc;
import com.java.code.model.Homework;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * HomeworkServlet
 *
 * @author JingqiWu
 * @date 2020/3/9
 *
 */
@WebServlet("/homework")
public class HomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Homework> list = HomeworkJdbc.selectAll();

        req.setAttribute("list", list);

        req.getRequestDispatcher("homework_s.jsp").forward(req, resp);
    }

}
