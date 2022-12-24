package com.harish.jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

public class JDBCPreparedStatementSelectImage {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/harish?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false","root","root");

        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM harish.images;");

        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            String image_Name = rs.getString(1);
            Blob image_blob = rs.getBlob(2);

            int blobLength = (int) image_blob.length();
            byte[] imageBytes = image_blob.getBytes(1, blobLength);

            image_blob.free();

            FileOutputStream imageLoc = new FileOutputStream("D:\\Training\\my_nature_download_image.jpg");
            imageLoc.write(imageBytes);
            imageLoc.flush();

            System.out.println("Name : "+ image_Name);
            System.out.println("Image : "+ image_blob);

        }

        stmt.close();
    }
}
