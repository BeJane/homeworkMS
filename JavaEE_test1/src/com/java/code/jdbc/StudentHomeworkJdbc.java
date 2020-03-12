package com.java.code.jdbc;

import com.java.code.model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentHomeworkJdbc
 * @author:Jingqi Wu
 * @date: 2020/3/9
 */
public class StudentHomeworkJdbc {
    public static void main(String[] args) {
        List<StudentHomework> list;
        list = IdSelect(1);

        for (StudentHomework sh : list){
            System.out.println(sh.getHomeworkContent());
        }

    }

    public static void addStudentHomework(StudentHomework sh) {
        String url = "jdbc:mysql://127.0.0.1:3306/school";
        String allUrl = url+"?user=root&password=123456&useSSL=false";
        String sqlString = "INSERT INTO s_student_homework" +
                " (student_id,homework_id,homework_title,homework_content,create_time) VALUES ('"
                +sh.getStudentId()+"','"+sh.getHomeworkId()+"','"+sh.getHomeworkTitle()
                +"','"+sh.getHomeworkContent()+"',NOW())";
        //System.out.println(sqlString);
        try(Connection connection = DriverManager.getConnection(allUrl)){

            try(Statement statement = connection.createStatement()){
                int rows=statement.executeUpdate(sqlString);

            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static List<StudentHomework> selectAll(){
        String url = "jdbc:mysql://127.0.0.1:3306/school";
        String allUrl = url+"?user=root&password=123456&useSSL=false";
        String sqlString = "SELECT * FROM s_student_homework";

        List<StudentHomework> list = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(allUrl)){

            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    while (resultSet.next()){
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));

                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public static List<StudentHomework> IdSelect(long id){
        String url = "jdbc:mysql://127.0.0.1:3306/school";
        String allUrl = url+"?user=root&password=123456&useSSL=false";
        String sqlString = "SELECT * FROM s_student_homework WHERE homework_id = '"+id+"'";

        List<StudentHomework> list = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(allUrl)){

            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    while (resultSet.next()){
                        StudentHomework sh = new StudentHomework();
                        sh.setId(resultSet.getLong("id"));
                        sh.setStudentId(resultSet.getLong("student_id"));
                        sh.setHomeworkId(resultSet.getLong("homework_id"));
                        sh.setHomeworkTitle(resultSet.getString("homework_title"));
                        sh.setHomeworkContent(resultSet.getString("homework_content"));
                        sh.setCreateTime(resultSet.getTimestamp("create_time"));

                        list.add(sh);
                    }
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
