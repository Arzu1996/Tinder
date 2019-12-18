package app.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConn{
  private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
//          "jdbc:mysql://localhost:3306/tindersc";
    private static final String USERNAME = "postgres";
//        "root";
    private static final String USER_PASS = "123456";
//        "";

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

