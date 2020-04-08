package code.jdbc;

import code.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * StudentJdbc
 * @author:Jingqi Wu
 * @date: 2020/3/9
 */
public class StudentService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /*
    public boolean addStudent(Student stu) {
        /*
        String sqlString = "INSERT INTO s_student (id,name,create_time) VALUES ('"
                +stu.getId()+"','"+stu.getName()+"',NOW())";

         */
/*
        try{
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO s_student (id,name,create_time) VALUES (?,?,NOW())");
            statement.setLong(1,stu.getId());
            statement.setString(2,stu.getName());
            // 执行更新操作
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    */


    public Map selectAll(){
        String sqlString = "SELECT * FROM s_student";

        Map list = jdbcTemplate.queryForMap(sqlString);

        System.out.println(list.toString());
        return list;
    }
}
