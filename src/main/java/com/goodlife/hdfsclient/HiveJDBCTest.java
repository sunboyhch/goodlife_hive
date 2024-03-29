package com.goodlife.hdfsclient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hive JDBC测试类
 */
public class HiveJDBCTest {
    public static void main(String[] args) throws Exception {
        // 驱动名称
        String driver = "org.apache.hive.jdbc.HiveDriver";
        // 连接地址，默认使用端口10000, 使用默认数据库
        String url = "jdbc:hive2://192.168.1.6:10000/default";
        // 用户名
        String username = "hadoop";
        // 密码
        String password = "hadoop";
        // 1.加载JDBC驱动
        Class.forName(driver);
        // 2.获取连接
        Connection conn = DriverManager.getConnection(url, username, password);
        //Connection conn = DriverManager.getConnection(url);
        Statement stmt = conn.createStatement();
        // 3.执行查询
        ResultSet res = stmt.executeQuery("select * from hu_test");
        // 4.处理结果
        while (res.next()) {
            System.out.println(res.getInt(1) + "\t" + res.getString(2));
        }
        // 5.关闭资源
        res.close();
        stmt.close();
        conn.close();
    }
}
