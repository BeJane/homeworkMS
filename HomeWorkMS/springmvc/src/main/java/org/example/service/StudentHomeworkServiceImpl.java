package org.example.service;

import org.example.context.SpringContextUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;


/**
 * @author wjq
 */
@Service
public class StudentHomeworkServiceImpl implements MyService {
    private JdbcTemplate jdbcTemplate =
            SpringContextUtil.getBean("jdbcTemplate");


    private ModelAndView mv = new ModelAndView();
    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String setModelAndView() {


        mv.addObject("id","id");
        mv.addObject("student_id","student_id");

        mv.addObject("title","homework_title");
        mv.addObject("content","homework_content");
        mv.addObject("time","create_time");

        return "初始化ModelAndView";
    }

    @Override
    public String add(Long id, String name){
        String sqlString =
                "INSERT INTO s_student (id,name,create_time) VALUES (?,?,NOW())";
        int rows = jdbcTemplate.update(sqlString,new Object[]{id,name});
        return "添加学生"+name;
    }
    @Override
    public ModelAndView selectAll() {

        String sqlString = "SELECT * FROM s_student";

        List<Map<String, Object>> students = jdbcTemplate.queryForList(sqlString);

        setModelAndView();
        //要跳转的页面
        mv.setViewName("addStudent_t");
        mv.addObject("list", students);
        return mv;
    }
}