package com.java.code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *优化数据库连接
 * 实现简单连接池
 * @author:Jingqi Wu
 * @date: 2020/3/15
 */
public class ConPool {

    private static String url = "jdbc:mysql://127.0.0.1:3306/school";
    private static String allUrl = url+"?user=root&password=123456&useSSL=false";
    private static String driverName = "com.mysql.cj.jdbc.Driver";

    private static int initCount = 3;
    private static int maxCount = 10;
    private static int currentCount = 0;

    private LinkedList<Connection> connectionsPool =
            new LinkedList<Connection>();

    public ConPool()

    {
        for(; currentCount < initCount; ) {
            try {
                // 连接池需要加载驱动？
                Class.forName(driverName);
                // 通过jdbc建立数据库连接
                Connection connection = DriverManager.getConnection(allUrl);
                this.connectionsPool.add(connection);
                currentCount++;
            } catch (SQLException | ClassNotFoundException e) {
                throw new ExceptionInInitializerError(e);
            }
        }
    }

    // 从连接池中拿走一个连接
    public Connection getConnection() throws SQLException{
        System.out.println("currentCount:"+currentCount+";list size:"+connectionsPool.size());
        synchronized (connectionsPool){
            if(connectionsPool.size()>0){
                return connectionsPool.removeFirst();
            }
            if(connectionsPool.size()< maxCount){
                Connection connection = DriverManager.getConnection(allUrl);
                currentCount++;
                return connection;
            }
        }
        throw new SQLException("超过最大连接");
    }

    // 释放连接，把连接放到连接池
    public void free(Connection connection){

        this.connectionsPool.add(connection);

    }

}
