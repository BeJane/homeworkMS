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

    // 使用连接池获取数据库连接
    private static ConPool dataSource = new ConPool();
    private static Connection connection;
    public HomeworkJdbc() {

        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 将连接还给数据库连接池
    public static void free(){
        dataSource.free(connection);
    }
    public static boolean addHomework(Homework h)  {
        String sqlString = "INSERT INTO s_homework (title,content,create_time) VALUES ('"
                +h.getTitle()+"','"+h.getContent()+"',NOW())";

        try(Statement statement = connection.createStatement()){

            statement.executeUpdate(sqlString);
        }catch(SQLException e){
            e.printStackTrace();
        }

        return true;
    }

    public static List<Homework> selectAll(){
        String sqlString = "SELECT * FROM s_homework";

        List<Homework> list = new ArrayList<>();

        try(Statement statement = connection.createStatement() ){
            try(ResultSet resultSet = statement.executeQuery(sqlString)){
                while (resultSet.next()){
                    Homework h = new Homework();
                    h.setId(resultSet.getLong("id"));h.setTitle(resultSet.getString("title"));
                    h.setContent(resultSet.getString("content"));
                    h.setCreateTime(resultSet.getTimestamp("create_time"));
                        list.add(h);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
