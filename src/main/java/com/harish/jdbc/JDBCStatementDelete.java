package com.harish.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCStatementDelete {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/harish","root","root");
        Statement stmt = connection.createStatement();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        System.out.println("Enter User ID To Delete: ");
        String readId = reader.readLine();
        int id =Integer.parseInt(readId);

        String insertQuery = "DELETE FROM harish.user WHERE id="+id+";";
        System.out.println(insertQuery);
        int result = stmt.executeUpdate(insertQuery);
        System.out.println("Updated Records : " + result);

        stmt.close();
    }
}
