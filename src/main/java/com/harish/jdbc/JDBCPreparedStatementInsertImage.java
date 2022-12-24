package com.harish.jdbc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPreparedStatementInsertImage {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/harish?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false","root","root");


        //Statement stmt = connection.createStatement();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO harish.images (name, image) VALUES (?,?);");

        String imageName ="Harish";
        FileInputStream image = new FileInputStream("D:\\Training\\nature_Image.jpg");

        stmt.setString(1,imageName);
        stmt.setBlob(2,image);

        int result = stmt.executeUpdate();


        System.out.println("Inserted Records Count: " + result);

        stmt.close();
    }
}
