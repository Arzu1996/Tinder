package app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn{
    private static final String DB_URL = "jdbc:mysql://remotemysql.com:3306/ZlZjKIQkMS";
    private static final String USERNAME = "ZlZjKIQkMS";
    private static final String USER_PASS = "KTl9ph7Hb3";

    private static Connection connection;

    private DbConn() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, USERNAME, USER_PASS);
            } catch (SQLException e) {
                throw new RuntimeException("Something went wrong during connection", e);
            }
        }
        return connection;
    }
}

