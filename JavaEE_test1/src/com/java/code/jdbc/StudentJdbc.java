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

    public static void main(String[] args) {
        Student stu = new Student();
        stu.setId(122);
        stu.setName("Jane");
        addStudent(stu);
    }
    public static void addStudent(Student stu) {
        String url = "jdbc:mysql://127.0.0.1:3306/school";
        String allUrl = url+"?user=root&password=123456&useSSL=false";
        String sqlString = "INSERT INTO s_student (id,name,create_time) VALUES ('"
                +stu.getId()+"','"+stu.getName()+"',NOW())";
        //System.out.println(sqlString);
        try(Connection connection = DriverManager.getConnection(allUrl)){

            try(Statement statement = connection.createStatement()){
                int rows=statement.executeUpdate(sqlString);

                }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static List<Student> selectAll(){
        String url = "jdbc:mysql://127.0.0.1:3306/school";
        String allUrl = url+"?user=root&password=123456&useSSL=false";
        String sqlString = "SELECT * FROM s_student";

        List<Student> list = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(allUrl)){

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
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
