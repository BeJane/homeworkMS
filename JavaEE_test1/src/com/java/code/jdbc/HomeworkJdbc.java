package com.java.code.jdbc;

import com.java.code.model.Homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * HomeworkJdbc
 * @author:Jingqi Wu
 * @date: 2020/3/9
 */
public class HomeworkJdbc {

    public static boolean addHomework(Homework h) {
        String url = "jdbc:mysql://127.0.0.1:3306/school";
        String allUrl = url+"?user=root&password=123456&useSSL=false";
        String sqlString = "INSERT INTO s_homework (title,content,create_time) VALUES ('"
                +h.getTitle()+"','"+h.getContent()+"',NOW())";


        try(Connection connection = DriverManager.getConnection(allUrl)){

            try(Statement statement = connection.createStatement()){
                int rows=statement.executeUpdate(sqlString);

                }

        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public static List<Homework> selectAll(){
        String url = "jdbc:mysql://127.0.0.1:3306/school";
        String allUrl = url+"?user=root&password=123456&useSSL=false";
        String sqlString = "SELECT * FROM s_homework";

        List<Homework> list = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(allUrl)){

            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sqlString)){
                    while (resultSet.next()){
                        Homework h = new Homework();
                        h.setId(resultSet.getLong("id"));
                        h.setTitle(resultSet.getString("title"));
                        h.setContent(resultSet.getString("content"));
                        h.setCreateTime(resultSet.getTimestamp("create_time"));

                        list.add(h);
                    }
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
