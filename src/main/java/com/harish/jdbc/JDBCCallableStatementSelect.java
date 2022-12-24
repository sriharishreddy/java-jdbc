package com.harish.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class JDBCCallableStatementSelect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/harish","root","root");

        CallableStatement stmt = connection.prepareCall("call harish.getMyUser();");
        ResultSet result = stmt.executeQuery();
        ResultSetMetaData rsmd =  result.getMetaData();
        System.out.println("Column Count : "+rsmd.getColumnCount());
        for(int i=1;i<=rsmd.getColumnCount();i++) {
            String column = rsmd.getColumnName(i);
            String type = rsmd.getColumnTypeName(i);
            int size = rsmd.getColumnDisplaySize(i);
            System.out.println("Column : " + column + " Type : " +type + " Size : "+size);
        }

        while (result.next()){
                int id = result.getInt(1);
                String name = result.getString("name");
                String password = result.getString(3);
                String email = result.getString("email");

            System.out.println(id +" "+ name +" "+ password +" "+ email);

        }



        stmt.close();
    }
}
