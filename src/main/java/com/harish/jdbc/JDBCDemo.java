package com.harish.jdbc;

import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/harish","root","root");
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM harish.user where id=1;");
        while (rs.next()){
            int userId = rs.getInt("id");
            String userName = rs.getString("name");
            String password = rs.getString("password");
            String email = rs.getString("email");

            System.out.println("Id : " +userId + " User Name : " + userName + " Password : " + password + " Email : "+email);
        }
        stmt.close();
    }
}
