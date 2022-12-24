package com.harish.jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCPreparedStatementInsertFile {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/harish?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false","root","root");


        //Statement stmt = connection.createStatement();
        PreparedStatement stmt = connection.prepareStatement("INSERT INTO harish.files (name, file) VALUES (?,?);");

        String fileName ="jdbc_tutorial";
        FileReader file = new FileReader("D:\\Training\\harish.txt");

        stmt.setString(1,fileName);
        stmt.setCharacterStream(2, file);

        int result = stmt.executeUpdate();


        System.out.println("Inserted Records Count: " + result);

        stmt.close();
    }
}
