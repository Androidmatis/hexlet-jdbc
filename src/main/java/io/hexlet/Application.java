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
            var dao = new UserDAO(conn);
            var user = new User("Tommy", "841343");
            var user2 = new User("Marry", "835124");
            dao.save(user);
            dao.save(user2);
            dao.delete(user.getId());
            dao.select();
        }
    }
}
