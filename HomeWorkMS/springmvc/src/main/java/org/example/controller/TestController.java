package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author:Jingqi Wu
 * @date: 2020/4/15
 */
@Controller
public class TestController {
    private StudentService studentService;
    @RequestMapping(value = "hello")
    public ModelAndView student() {

        org.springframework.web.servlet.ModelAndView mv = new ModelAndView();
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

}
