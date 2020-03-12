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
 * AddHomeworkServlet
 *
 * @author JingqiWu
 * @date 2020-3-9
 */
@WebServlet("/addHomework")
public class AddHomeworkServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Homework> list = HomeworkJdbc.selectAll();

        req.setAttribute("list", list);

        req.getRequestDispatcher("addHomework_t.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Homework hw = new Homework();
        /*浏览器提交的数据在提交给服务器之前设置编码方式为UTF-8*/
        req.setCharacterEncoding("UTF-8");
        // 赋值
        hw.setTitle(req.getParameter("title"));
        hw.setContent(req.getParameter("content"));
        HomeworkJdbc.addHomework(hw);
        resp.sendRedirect("homework_t.jsp");
    }
}