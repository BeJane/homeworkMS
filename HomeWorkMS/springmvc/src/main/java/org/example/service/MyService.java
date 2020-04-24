package org.example.service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author:Jingqi Wu
 * @date: 2020/4/23
 */
public interface MyService {

    /**
     * @param jdbcTemplate
     */
    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
    /**
     * This is the method to be used to create
     * a record in the Student and Marks tables.
     * @return
     */
    String setModelAndView();

    /**
     * @param id
     * @param name
     * @return
     */
    String addStudent(Long id, String name);
    /**
     *  This is the method to be used to list down all the records
     * @return
     */
    ModelAndView selectAll();

    /**
     * @param object
     * @return
     */
    ModelAndView select(Object object);
}
