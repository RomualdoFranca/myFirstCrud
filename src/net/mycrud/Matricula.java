package net.mycrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Matricula {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        String dbjdbc = "jdbc:mysql://localhost:3306/escola";
        String dbUser = "root";
        String dbPassword = "PuG@10%92";

        Connection connection = DriverManager.getConnection(dbjdbc, dbUser, dbPassword);
        String dbSql = "INSERT INTO matricula (nome, idade, serie) VALUES ('Jairo', 10, '6°')";

        Statement statement = connection.createStatement();

        int rows = statement.executeUpdate(dbSql);

        connection.close();
        sc.close();
    }



}
