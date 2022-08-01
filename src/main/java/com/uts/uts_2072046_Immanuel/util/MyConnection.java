package com.uts.uts_2072046_Immanuel.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection getConnection(){
        String database = "utssa";
        Connection conn;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + database,
                    "root",
                    ""
            );

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }

}
