package application;

import entities.Produtos;

import java.sql.*;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);

        String jdbcURL = "jdbc:mysql://localhost:3306/produtos";
        String dbUserName = "root";
        String dbPassword = "PuG@10%92";

        Connection connection = DriverManager.getConnection(jdbcURL, dbUserName, dbPassword);

        Produtos produtos = new Produtos();
        System.out.println("Entre com os dados dos produtos");
        System.out.print("Nome: ");
        produtos.name = sc.nextLine();
        System.out.print("Preço: ");
        produtos.price = sc.nextDouble();
        System.out.print("Quantidade: ");
        int quantity = sc.nextInt();
        produtos.addProducts(quantity);

        String sql = "INSERT INTO estoque(nome_produto," +
                "preco, qnt_estoque," +
                "valor_total_Produto," +
                "valor_total_estoque )" +
                "VALUES(?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, produtos.name);
        statement.setDouble(2, produtos.price);
        statement.setInt(3, produtos.quantity);
        statement.setString(4, produtos.addProducts(quantity));


        int rows =  statement.executeUpdate();

        if (rows > 0) {
            System.out.println("A new user has been inserted successfully");
        }

        connection.close();
        sc.close();
    }
}
