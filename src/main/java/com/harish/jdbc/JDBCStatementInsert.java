package com.harish.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class JDBCStatementInsert {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/harish","root","root");
        Statement stmt = connection.createStatement();

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

        String insertQuery = "INSERT INTO harish.user (id, name, password, email) VALUES (" + id + ", " + '\u0022'+name+'\u0022' +", " + '\u0022'+password+'\u0022' + ", " + '\u0022'+email+'\u0022' + ");";
        System.out.println(insertQuery);
        int result = stmt.executeUpdate(insertQuery);
        System.out.println("Updated Records : " + result);

        stmt.close();
    }
}
