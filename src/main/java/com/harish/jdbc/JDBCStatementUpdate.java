package com.harish.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatementUpdate {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/harish","root","root");
        Statement stmt = connection.createStatement();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter User ID to Update : ");
        String readId = reader.readLine();
        int id =Integer.parseInt(readId);

        System.out.println("Enter User Name : ");
        String name = reader.readLine();

        System.out.println("Enter User Email : ");
        String email = reader.readLine();

        String updateQuery = "UPDATE harish.user SET name = " + '\u0022' + name + '\u0022' + ", email= " + '\u0022' + email + '\u0022' + " WHERE id = "+id+";";
        System.out.println(updateQuery);

        int result = stmt.executeUpdate(updateQuery);
        System.out.println("Updated Records : " + result);

        stmt.close();
    }
}
