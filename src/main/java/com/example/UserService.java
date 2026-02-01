package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    private static final String DB_URL = "jdbc:mysql://localhost/db";
    private static final String DB_USER = "root";

    // Password should come from environment variables or secrets manager
    private final String password;

    public UserService(String password) {
        this.password = password;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, password);
    }

    public void findUser(String username) throws SQLException {

        String query = "SELECT * FROM users WHERE name = ?";

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.executeQuery();
        }
    }

    public void deleteUser(String username) throws SQLException {

        String query = "DELETE FROM users WHERE name = ?";

        try (Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.executeUpdate();
        }
    }
}
