package org.example.service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author:Jingqi Wu
 * @date: 2020/4/23
 */
public interface StudentService {

    /**
     * @param jdbcTemplate
     */
    void setJdbcTemplate(JdbcTemplate jdbcTemplate);
    /**
     * This is the method to be used to set the ModelAndView
     * @return
     */
    String setModelAndView();

    /**
     * @param id
     * @param name
     * @return
     */
    String add(Long id, String name);
    /**
     *  This is the method to be used to list down all the records
     * @return
     */
    ModelAndView selectAll();

}
