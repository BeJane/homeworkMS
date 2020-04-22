package org.example.controller;

import org.example.dao.StudentDAO;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Map;


/**
 * Controller
 * for addStudent_t.jsp
 * 查看学生列表，添加学生
 * @author:Jingqi Wu
 * @date: 2020/4/1
 */
@Controller

public class StudentController {


    @Autowired
    private StudentDAO studentService;

    @RequestMapping(value = "student", method = RequestMethod.GET)
    public ModelAndView student() {

        ModelAndView mv = new ModelAndView();
        //要跳转的页面
        mv.setViewName("addStudent_t");

        List<Map<String, Object>> studentLists = studentService.listStudents();
        System.out.println(studentLists.get(1).toString());
        mv.addObject("list", studentLists);
        mv.addObject("id","id");
        mv.addObject("name","name");
        mv.addObject("time","create_time");
        return mv;
    }

    @RequestMapping(value="/addStudent", method=RequestMethod.POST)
    private String addStudent(@RequestParam("id") Long id,
                          @RequestParam("name") String name){

        studentService.create(id,name);
        return "redirect:student";
    }

}

