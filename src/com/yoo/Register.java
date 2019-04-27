package com.yoo;

import java.sql.*;

public class Register {

    private Statement stmt = null;
    private Connection conn = null;
    private int numberOfRecord;

    public boolean registerUser(String userName, String password){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prac?serverTimezone=UTC", "root","1234"); // JDBC 연결
            stmt = conn.createStatement(); // SQL문 처리용 Statement 객체 생성
            ResultSet srs;
            srs = stmt.executeQuery("select count(*) from user"); // 레코드 개수를 얻어오는 쿼리
            srs.next();
            numberOfRecord = srs.getInt(1);
        } catch (ClassNotFoundException e) {
            handleError(e.getMessage());
        } catch (SQLException e) {
            handleError(e.getMessage());
        }
        return true;
    }

    private static void handleError(String string) {
        System.out.println(string);
        System.exit(1);
    }

    public static boolean authenticate(String userName, String password) {
        return new Register().registerUser(userName, password);
    }
}

