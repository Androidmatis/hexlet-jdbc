package io.hexlet;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        try (var conn = DriverManager.getConnection("jdbc:h2:mem:hexlet_test")) {
            var sql = "CREATE TABLE users (id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(255), phone VARCHAR(255))";
            try (var statement = conn.createStatement()) {
                statement.execute(sql);
            }
            var sql2 = "INSERT INTO users (username, phone) VALUES (?, ?)";
            try (var preparedStatement = conn.prepareStatement(sql2)) {
                preparedStatement.setString(1, "Tommy");
                preparedStatement.setString(2, "841343");
                preparedStatement.executeUpdate();
                preparedStatement.setString(1, "Marry");
                preparedStatement.setString(2, "835124");
                preparedStatement.executeUpdate();
            }
            var sql3 = "DELETE FROM users WHERE username = ?";
            try (var preparedStatement = conn.prepareStatement(sql3)) {
                preparedStatement.setString(1, "Tommy");
                preparedStatement.execute();
            }
            var sql4 = "SELECT * FROM users";
            try (var statement4 = conn.createStatement()) {
                var resultSet = statement4.executeQuery(sql4);
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("username"));
                    System.out.println(resultSet.getString("phone"));
                }
            }
        }
    }
}
