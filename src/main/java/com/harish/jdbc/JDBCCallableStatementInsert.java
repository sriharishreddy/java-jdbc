package com.harish.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class JDBCCallableStatementInsert {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/harish","root","root");

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

        CallableStatement stmt = connection.prepareCall("call harish.insertMyUser(?,?,?,?);");
        stmt.setInt(1,id);
        stmt.setString(2,name);
        stmt.setString(3,password);
        stmt.setString(4,email);

         stmt.execute();

        stmt.close();
    }
}
