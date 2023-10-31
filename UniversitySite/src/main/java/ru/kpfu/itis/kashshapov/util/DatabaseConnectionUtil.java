package ru.kpfu.itis.kashshapov.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionUtil {
    private static final String URL = "jdbc:postgresql://localhost:5432/university";
    private static final String USER = "postgres";
    private static final String PASSWORD = "ghbdtn_z_flvby";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );
            }
        } catch (ClassNotFoundException | SQLException e){
            throw new RuntimeException(e);
        }

        return connection;
    }
}
