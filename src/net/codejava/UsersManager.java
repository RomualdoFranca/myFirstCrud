package net.codejava;

import java.sql.*;
import java.util.Scanner;

public class UsersManager {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);

        String jdbcURL = "jdbc:mysql://localhost:3306/simpleCrud";
        String dbUserName = "root";
        String dbPassword = "PuG@10%92";

        Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);
//        String sql = "INSERT INTO users (username, password, fullname, email)" +
//                "VALUES ('Romualdo', 'mamao','Romualdo Franca', 'romualdo@email');";
//        Statement statement = connection.createStatement();

        // Atualizando BD atraves de inputs do usuário
        System.out.println("Input username: ");
        String username = scanner.nextLine();
        System.out.println("Input password: ");
        String password = scanner.nextLine();
        System.out.println("Input fullname: ");
        String fullname = scanner.nextLine();
        System.out.println("Input email: ");
        String email = scanner.nextLine();

        String sqlInputs = "INSERT INTO users(username, password, fullname, email) VALUES(?, ?, ?, ?)";
        PreparedStatement statement1 = connection.prepareStatement(sqlInputs);
        statement1.setString(1, username);
        statement1.setString(2, password);
        statement1.setString(3, fullname);
        statement1.setString(4, email);

        int rows =  statement1.executeUpdate();

//      Atualizando BD sem Scanner
//        String username = "Lua";
//        String password = "peludos";
//        String fullname = "Lua Lora";
//        String email = "lua@email.com";

//        String sql = "INSERT INTO users (username, password, fullname, email)" +
//                "VALUES(?, ?, ?, ?)";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setString(1, username);
//        statement.setString(2, password);
//        statement.setString(3, fullname);
//        statement.setString(4, email);
//        int rows =  statement.executeUpdate();




        if (rows > 0) {
            System.out.println("A new user has been inserted successfully");
        }
        scanner.close();
//        if (connection != null) {
//            System.out.println("Connected to the database");
//        }
    }
}
