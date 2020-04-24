package org.example.controller;

import org.example.context.SpringContextUtil;
import org.example.service.HomeworkService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


/**
 * 控制器
 * 教师查看作业列表，教师发布作业
 * 学生查看作业
 * @author:Jingqi Wu
 * @date: 2020/4/1
 */
@Controller

public class HomeworkController {

    /**
     * 教师首页，查看已发布作业列表
     * @return
     */
    @RequestMapping(value = "teacher", method = RequestMethod.GET)
    public ModelAndView asTeacher() {

        HomeworkService homeworkService = (HomeworkService)
                SpringContextUtil.getBean("homeworkServiceImpl");
        ModelAndView mv = homeworkService.select();
        //要跳转的页面
        mv.setViewName("homework_t");

        return mv;
    }
    /**
     * 教师发布作业
     */
    @RequestMapping(value="/addHomework", method=RequestMethod.GET)
    private String addHomework(){


        return "addHomework_t";
    }
    @RequestMapping(value="/addHomework", method=RequestMethod.POST)
    private String saveHomework(@RequestParam("title") String title,
                                @RequestParam("content") String content){

        HomeworkService homeworkService = (HomeworkService)
                SpringContextUtil.getBean("homeworkServiceImpl");
        homeworkService.addHomework(title,content);
        return "redirect:teacher";
    }

    /**
     * 学生版首页，查看已发布作业列表
     * @return
     */

    @RequestMapping(value = "asStudent", method = RequestMethod.GET)
    public ModelAndView asStudent() {
        HomeworkService homeworkService = (HomeworkService)
            SpringContextUtil.getBean("homeworkServiceImpl");
        ModelAndView mv = homeworkService.select();

        //要跳转的页面
        mv.setViewName("homework_s");

        return mv;
    }


}

