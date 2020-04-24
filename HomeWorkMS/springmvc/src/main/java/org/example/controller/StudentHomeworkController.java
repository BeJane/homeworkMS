package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;


/**
 * 控制器
 * 教师查看学生作业列表，学生提交作业
 * @author:Jingqi Wu
 * @date: 2020/4/13
 */
@Controller

public class StudentHomeworkController {

    private ModelAndView mv = new ModelAndView();


    @RequestMapping(value = "studentHomework", method = RequestMethod.GET)
    public ModelAndView studentHomework(@RequestParam("id") Long id) {
        String sqlString = "SELECT * FROM s_student_homework WHERE homework_id = ?";

        //要跳转的页面
        mv.setViewName("studentHomework");
        setMv();

        List<Map<String, Object>> list
                = jdbcTemplate.queryForList(sqlString,new Object[]{id});
        System.out.println(list);
        mv.addObject("list", list);

        mv.addObject("homework_Id",id);
        return mv;
    }


    @RequestMapping(value="searchStudentHomework", method=RequestMethod.POST)
    private ModelAndView searchStudentHomework(@RequestParam("homeworkId") Long homeworkId,
                              @RequestParam("studentId") Long studentId){

        //要跳转的页面
        mv.setViewName("studentHomework");
        setMv();

        String sqlString =
                "SELECT * FROM s_student_homework WHERE homework_id=? and student_id=?";
        List<Map<String, Object>> list
                = jdbcTemplate.queryForList(sqlString,new Object[]{homeworkId,studentId});
        System.out.println("教师查询学生作业"+list);
        mv.addObject("list", list);

        mv.addObject("homework_Id",homeworkId);
        return mv;
    }

    /**
     * 学生提交作业
      */
    @RequestMapping(value = "addStudentHomework", method=RequestMethod.GET)
    public ModelAndView addStudentHomework(@RequestParam("id") Long homeworkId) {

        //要跳转的页面
        mv.setViewName("addStudentHomework");
        setMv();
        mv.addObject("homework_Id",homeworkId);
        return mv;
    }

    @RequestMapping(value = "addStudentHomework", method=RequestMethod.POST)
    public String addStudentHomework(@RequestParam("id") Long homeworkId,
                                           @RequestParam("s_id") Long studentId,
                                           @RequestParam("title") String title,
                                           @RequestParam("content") String content) {

        String sqlString =
                "INSERT INTO s_student_homework" +
                        " (student_id,homework_id,homework_title,homework_content,create_time) VALUES (?,?,?,?,NOW())";
        int rows = jdbcTemplate.update(sqlString,
                new Object[]{studentId,homeworkId,title,content});
        System.out.println("学生提交作业 "+rows);
        return "redirect:asStudent";
    }

}

