package org.example.java.code.jdbc;

import org.example.java.code.model.Student;

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
    private Connection connection;

    public StudentJdbc(){
        try {
            connection= dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 将连接还给数据库连接池
    public void free(){
        dataSource.free(connection);
    }
    public boolean addStudent(Student stu) {
        /*
        String sqlString = "INSERT INTO s_student (id,name,create_time) VALUES ('"
                +stu.getId()+"','"+stu.getName()+"',NOW())";

         */

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

    public List<Student> selectAll(){
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
