package org.example.java.code.servlet;

import org.example.java.code.jdbc.HomeworkJdbc;
import org.example.java.code.model.Homework;

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
        HomeworkJdbc homeworkJdbc = new HomeworkJdbc();
        List<Homework> list = homeworkJdbc.selectAll();

        homeworkJdbc.free();
        req.setAttribute("list", list);

        req.getRequestDispatcher("homework_s.jsp").forward(req, resp);
    }

}
