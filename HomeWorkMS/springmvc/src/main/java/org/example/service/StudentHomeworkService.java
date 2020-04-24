package org.example.service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author:Jingqi Wu
 * @date: 2020/4/23
 */
public interface StudentHomeworkService {

    /**
     * @param jdbcTemplate
     */
    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
    /**
     * This is the method to be used to set the ModelAndView
     * @return
     */
    ModelAndView getModelAndView();

    /**
     * 学生提交作业
     * @param homeworkId
     * @param studentId
     * @param title
     * @param content
     * @return
     */
    String addStudentHomework(
            Long homeworkId, Long studentId,String title,String content);
    /**
     *  This is the method to be used to list down all
     *  students' homework
     * @return
     */
    ModelAndView select(Long homeworkId );

    /**
     * This is the method to be used to search the student's homework
     * @param homeworkId
     * @param studentId
     * @return
     */
    ModelAndView select(Long homeworkId, Long studentId );
}
