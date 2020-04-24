package org.example.service;

import org.example.context.SpringContextUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @author:Jingqi Wu
 * @date: 2020/4/24
 */
public class HomeworkServiceImpl implements HomeworkService {
    private JdbcTemplate jdbcTemplate =
            SpringContextUtil.getBean("jdbcTemplate");
    private ModelAndView mv = new ModelAndView();
    /**
     * @param jdbcTemplate
     */
    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;

    }

    /**
     * This is the method to be used to set the ModelAndView
     *
     * @return
     */
    @Override
    public ModelAndView getModelAndView() {

        mv.addObject("id","id");
        mv.addObject("title","title");
        mv.addObject("content","content");
        mv.addObject("time","create_time");

        return mv;
    }


    /**
     * This is the method to be used to list down all homework
     *
     * @return
     */
    @Override
    public ModelAndView select() {

        String sql = "select * from s_homework";
        List <Map<String, Object>> homework = jdbcTemplate.queryForList(sql);

        getModelAndView();
        mv.addObject("list",homework);
        return mv;
    }

    /**
     * 老师发布作业
     *
     * @param title
     * @param content
     * @return
     */
    @Override
    public String addHomework(String title, String content) {
        String sql = "insert into s_homework (title,content,create_time)" +
                "values (?,?,NOW())";
        jdbcTemplate.update(sql,new Object[]{title,content});

        return "老师发布作业";
    }
}
