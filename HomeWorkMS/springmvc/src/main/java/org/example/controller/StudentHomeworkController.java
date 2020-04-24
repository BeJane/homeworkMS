package org.example.controller;

import org.example.context.SpringContextUtil;
import org.example.service.StudentHomeworkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 控制器
 * 教师查看学生作业列表，学生提交作业
 * @author:Jingqi Wu
 * @date: 2020/4/13
 */
@Controller

public class StudentHomeworkController {

    /**
     * 老师查看学生作业
     * @param id
     * @return
     */
    @RequestMapping(value = "studentHomework", method = RequestMethod.GET)
    public ModelAndView studentHomework(@RequestParam("id") Long id) {
        StudentHomeworkService studentHomeworkService = (StudentHomeworkService)
                SpringContextUtil.getBean("studentHomeworkServiceImpl");

        ModelAndView mv = studentHomeworkService.select(id);

        //要跳转的页面
        mv.setViewName("studentHomework");
        return mv;
    }


    /**
     * @param homeworkId
     * @param studentId
     * @return
     */
    @RequestMapping(value="searchStudentHomework", method=RequestMethod.POST)
    private ModelAndView searchStudentHomework
            (@RequestParam("homeworkId") Long homeworkId,
             @RequestParam("studentId") Long studentId){

        StudentHomeworkService studentHomeworkService = (StudentHomeworkService)
                SpringContextUtil.getBean("studentHomeworkServiceImpl");

        ModelAndView mv = studentHomeworkService.select(homeworkId,studentId);

        //要跳转的页面
        mv.setViewName("studentHomework");

         return mv;
    }

    /**
     * 学生提交作业
      */
    @RequestMapping(value = "addStudentHomework", method=RequestMethod.GET)
    public ModelAndView addStudentHomework(@RequestParam("id") Long homeworkId) {

        StudentHomeworkService studentHomeworkService = (StudentHomeworkService)
                SpringContextUtil.getBean("studentHomeworkServiceImpl");

        ModelAndView mv = studentHomeworkService.getModelAndView();
        //要跳转的页面
        mv.setViewName("addStudentHomework");
        mv.addObject("homework_Id",homeworkId);
        return mv;
    }

    @RequestMapping(value = "addStudentHomework", method=RequestMethod.POST)
    public String addStudentHomework(@RequestParam("id") Long homeworkId,
                                           @RequestParam("s_id") Long studentId,
                                           @RequestParam("title") String title,
                                           @RequestParam("content") String content) {

        StudentHomeworkService studentHomeworkService = (StudentHomeworkService)
                SpringContextUtil.getBean("studentHomeworkServiceImpl");

        studentHomeworkService.addStudentHomework(homeworkId,studentId,title,content);


        return "redirect:asStudent";
    }

}

