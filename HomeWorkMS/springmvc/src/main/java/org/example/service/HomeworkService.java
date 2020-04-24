package org.example.service;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author:Jingqi Wu
 * @date: 2020/4/23
 */
public interface HomeworkService {

    public String setJdbcTemplate(JdbcTemplate jdbcTemplate);
    /**
     * This is the method to be used to create
     * a record in the Student and Marks tables.
     */
    public String setModelAndView();
    public String add(Long id, String name);
    /**
     * This is the method to be used to list down
     * all the records from the Student and Marks tables.
     */
    public ModelAndView selectAll();
}
