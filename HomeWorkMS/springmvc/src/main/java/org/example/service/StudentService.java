package org.example.service;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.example.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentService implements StudentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Long id, String name){
        String sqlString =
                "INSERT INTO s_student (id,name,create_time) VALUES (?,?,NOW())";
        int rows = jdbcTemplate.update(sqlString,new Object[]{id,name});
        System.out.println("添加学生 "+rows);
    }
    @Override
    public List<Map<String, Object>> listStudents() {

        String sqlString = "SELECT * FROM s_student";

        List<Map<String, Object>> students = jdbcTemplate.queryForList(sqlString);
        System.out.println(students.get(1).toString());
        return students;
    }
}