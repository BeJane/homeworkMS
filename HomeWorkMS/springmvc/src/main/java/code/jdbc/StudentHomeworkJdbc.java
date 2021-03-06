package code.jdbc;

import code.model.StudentHomework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentHomeworkJdbc
 * @author:Jingqi Wu
 * @date: 2020/3/9
 */
public class StudentHomeworkJdbc {

    private static ConPool dataSource = new ConPool();
    private  Connection connection;

    public StudentHomeworkJdbc(){
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 将连接还给数据库连接池
    public void free(){
        dataSource.free(connection);
    }

    public boolean addStudentHomework(StudentHomework sh) {
        /*
        String sqlString = "INSERT INTO s_student_homework" +
                " (student_id,homework_id,homework_title,homework_content,create_time) VALUES ('"
                +sh.getStudentId()+"','"+sh.getHomeworkId()+"','"+sh.getHomeworkTitle()
                +"','"+sh.getHomeworkContent()+"',NOW())";

         */
        try(PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO s_student_homework" +
                " (student_id,homework_id,homework_title,homework_content,create_time) VALUES (?,?,?,?,NOW())"
        )){

            statement.setLong(1,sh.getStudentId());
            statement.setLong(2,sh.getHomeworkId());
            statement.setString(3,sh.getHomeworkTitle());

            statement.setString(4,sh.getHomeworkContent());
            // 执行更新操作
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public List<StudentHomework> selectAll(){
        String sqlString = "SELECT * FROM s_student_homework";

        List<StudentHomework> list = new ArrayList<>();
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
        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public List<StudentHomework> select(long homeworkId){
        String sqlString = "SELECT * FROM s_student_homework WHERE homework_id = '"
                +homeworkId+"'";

        List<StudentHomework> list = new ArrayList<>();
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

        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }

    public List<StudentHomework> select(long homeworId,long studentId){
        String sqlString = "SELECT * FROM s_student_homework WHERE homework_id = '"
                +homeworId+"' and student_id = '" + studentId + "'";

        List<StudentHomework> list = new ArrayList<>();
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

        } catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
