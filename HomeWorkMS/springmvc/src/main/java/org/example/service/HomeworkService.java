package org.example.service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author:Jingqi Wu
 * @date: 2020/4/23
 */
public interface HomeworkService {

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
     * 老师发布作业
     * @param title
     * @param content
     * @return
     */
    String addHomework(String title,String content);
    /**
     *  This is the method to be used to list down all homework
     * @return
     */
    ModelAndView select();

}
