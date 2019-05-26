package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionPool {

    private static ConnectionPool instance;

    private ConnectionPool() {

    }

    private static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    public static Connection getConnection() {

        ResourceBundle resource = ResourceBundle.getBundle("dao/database");

        String url = resource.getString("url");
        String user = resource.getString("user");
        String password = resource.getString("password");

        try {
            return DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
