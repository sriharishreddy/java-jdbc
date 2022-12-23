package com.harish.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class JDBCPreparedStatementInsert {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/harish","root","root");

        //Statement stmt = connection.createStatement();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO harish.user (id, name, password, email) VALUES (?,?,?,?);");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter User ID : ");
        String readId = reader.readLine();
        int id =Integer.parseInt(readId);

        System.out.println("Enter User Name : ");
        String name = reader.readLine();
        System.out.println("Enter User Password : ");
        String password = reader.readLine();
        System.out.println("Enter User Email : ");
        String email = reader.readLine();
/*
            int id = 12;
            String name = "Harish";
            String password = "harish123";
            String email = "harish@gmail.com";
*/
        stmt.setInt(1,id);
        stmt.setString(2,name);
        stmt.setString(3,password);
        stmt.setString(4,email);

        int result = stmt.executeUpdate();


        System.out.println("Inserted Records Count: " + result);

        stmt.close();
    }
}
