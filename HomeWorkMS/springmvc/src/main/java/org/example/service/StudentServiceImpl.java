package org.example.service;
import java.util.List;
import java.util.Map;

import org.example.context.SpringContextUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author wjq
 */
@Service
public class StudentServiceImpl implements MyService {
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
        mv.addObject("name","name");
        mv.addObject("time","create_time");

        return "初始化ModelAndView";
    }

    @Override
    public String addStudent(Long id, String name){
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
        mv.addObject("list", students);
        return mv;
    }

    @Override
    public ModelAndView select(Object object) {
        return null;
    }

}