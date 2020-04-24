package org.example.controller;

import org.example.service.MyService;
import org.example.context.SpringContextUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * Controller
 * for addStudent_t.jsp
 * 查看学生列表，添加学生
 * @author:Jingqi Wu
 * @date: 2020/4/1
 */
@Controller

public class StudentController {

    @RequestMapping(value = "student", method = RequestMethod.GET)
    public ModelAndView student() {
        MyService myService = (MyService)
                SpringContextUtil.getBean("studentServiceImpl");

        ModelAndView studentLists = myService.selectAll();

        //要跳转的页面
        studentLists.setViewName("addStudent_t");
        return studentLists;
    }

    @RequestMapping(value="/addStudent", method=RequestMethod.POST)
    private String addStudent(@RequestParam("id") Long id,
                          @RequestParam("name") String name){

        MyService myService = (MyService)
                SpringContextUtil.getBean("studentServiceImpl");

        myService.add(id,name);
        return "redirect:student";
    }

}

