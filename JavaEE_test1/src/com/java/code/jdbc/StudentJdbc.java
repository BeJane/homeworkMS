package com.java.code.jdbc;

import com.java.code.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentJdbc
 * @author:Jingqi Wu
 * @date: 2020/3/9
 */
public class StudentJdbc {

    private static ConPool dataSource = new ConPool();
    private static Connection connection;

    public StudentJdbc(){
        try {
            connection= dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 将连接还给数据库连接池
    public static void free(){
        dataSource.free(connection);
    }
    public static boolean addStudent(Student stu) {
        String sqlString = "INSERT INTO s_student (id,name,create_time) VALUES ('"
                +stu.getId()+"','"+stu.getName()+"',NOW())";

        try(Statement statement = connection.createStatement()){
            int rows=statement.executeUpdate(sqlString);

        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public static List<Student> selectAll(){
        String sqlString = "SELECT * FROM s_student";

        List<Student> list = new ArrayList<>();
        try(Statement statement = connection.createStatement()){
            try(ResultSet resultSet = statement.executeQuery(sqlString)){
                while (resultSet.next()){
                    Student stu = new Student();
                    stu.setId(resultSet.getLong("id"));
                    stu.setName(resultSet.getString("name"));
                    stu.setCreateTime(resultSet.getTimestamp("create_time"));

                    list.add(stu);
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
