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
public class StudentHomeworkServiceImpl implements StudentHomeworkService {
    private JdbcTemplate jdbcTemplate =
            SpringContextUtil.getBean("jdbcTemplate");


    private ModelAndView mv = new ModelAndView();
    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ModelAndView getModelAndView() {


        mv.addObject("id","id");
        mv.addObject("student_id","student_id");

        mv.addObject("title","homework_title");
        mv.addObject("content","homework_content");
        mv.addObject("time","create_time");

        return mv;
    }

    @Override
    public String addStudentHomework(Long homeworkId, Long studentId, String title, String content) {
        String sqlString =
                "INSERT INTO s_student_homework" +
                        " (student_id,homework_id,homework_title,homework_content,create_time) VALUES (?,?,?,?,NOW())";
        int rows = jdbcTemplate.update(sqlString,
                new Object[]{studentId,homeworkId,title,content});
        return "学生提交一份作业";
    }

    @Override
    public ModelAndView select(Long homeworkId) {


        String sqlString = "SELECT * FROM s_student_homework WHERE homework_id = ?";


        List<Map<String, Object>> studentHomework
                = jdbcTemplate.queryForList(sqlString,new Object[]{homeworkId});

        getModelAndView();

        mv.addObject("list", studentHomework);

        mv.addObject("homework_Id",homeworkId);
        return mv;
    }

    @Override
    public ModelAndView select(Long homeworkId, Long studentId) {
        String sqlString =
                "SELECT * FROM s_student_homework WHERE homework_id=? and student_id=?";
        List<Map<String, Object>> list
                = jdbcTemplate.queryForList(sqlString,new Object[]{homeworkId,studentId});

        mv.addObject("list", list);

        mv.addObject("homework_Id",homeworkId);

        return mv;
    }
}