package org.example.controller;

import code.jdbc.HomeworkJdbc;
import code.jdbc.StudentHomeworkJdbc;
import code.model.Homework;
import code.model.StudentHomework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * 控制器
 * @author:Jingqi Wu
 * @date: 2020/4/1
 */
@Controller

public class TestController2 {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public ModelAndView addStudent() {

        ModelAndView mv = new ModelAndView();
        //要跳转的页面
        mv.setViewName("addStudent_t");
        List<Map<String, Object>> studentLists = jdbcTemplate.queryForList("SELECT * FROM s_student");

        mv.addObject("list", studentLists);
        return mv;
    }


    @RequestMapping("addStudentHomework")
    public void submit(@RequestParam(value = "HomeworkID")int homeworkId,
                       @RequestParam(value = "StudentID")String studentId,
                       @RequestParam(value = "HomeworkTitle")String title,
                       @RequestParam(value = "HomeworkContent")String content){

        ApplicationContext ctx = new AnnotationConfigApplicationContext(StudentHomework.class);
        StudentHomework sh = new StudentHomework();
        sh.setHomeworkId(homeworkId);
        sh.setStudentId(Long.parseLong(studentId));
        sh.setHomeworkTitle(title);
        sh.setHomeworkContent(content);
        StudentHomeworkJdbc studentHomeworkJdbc = new StudentHomeworkJdbc();
        if(studentHomeworkJdbc.addStudentHomework(sh))
            System.out.println("插入成功");
    }

    @RequestMapping("homework_t")
    public void teacher(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
       HomeworkJdbc homeworkJdbc = new HomeworkJdbc();
        List<Homework> list = homeworkJdbc.selectAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/homework_t").forward(req,resp);
    }

    @RequestMapping("homework_s")
    public void student(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("跳入学生界面");

        HomeworkJdbc homeworkJdbc = new HomeworkJdbc();
        List<Homework> list = homeworkJdbc.selectAll();
        req.setAttribute("list",list);
        req.getRequestDispatcher("/homework_s").forward(req,resp);
    }
}

