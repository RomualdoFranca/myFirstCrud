package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersManager {
    public static void main(String[] args) throws SQLException {

        String jdbcURL = "jdbc:mysql://localhost:3306/simpleCrud";
        String userName = "root";
        String password = "PuG@10%92";

        Connection connection = DriverManager.getConnection(jdbcURL, userName, password);
        String sql = "INSERT INTO users (username, password, fullname, email)" +
                "VALUES ('Romualdo', 'mamao','Romualdo Franca', 'romualdo@email');";
        Statement statement = connection.createStatement();
        int rows =  statement.executeUpdate(sql);
        if (rows > 0) {
            System.out.println("A new user has been inserted successfully");
        }
//        if (connection != null) {
//            System.out.println("Connected to the database");
//        }
    }
}
