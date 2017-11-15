package hometask8.t02;

import hometask8.t01.ConnectionProperties;
import hometask8.t01.JDBCOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.IntStream;

public class ConnectionPool {
    private BlockingQueue<Connection> poolFree = new LinkedBlockingQueue<>();
    private BlockingQueue<Connection> poolUsed = new LinkedBlockingQueue<>();


    private String path = "Hometasks/src/main/resources/hometask8/db.properties";
    private String driver;
    private String url;
    private String user;
    private String password;
    private int minPoolSize;

    public ConnectionPool() throws ConnectionPoolException {
        Properties properties = ConnectionProperties.getProperties(path);
        this.driver = properties.getProperty("db.driver");
        this.url = properties.getProperty("db.url");
        this.user = properties.getProperty("db.user");
        this.password = properties.getProperty("db.password");
        this.minPoolSize = 5;
        initConnectionPool();
    }

    private void initConnectionPool() throws ConnectionPoolException {
        try {
            Class.forName(driver);
            for (int count = 0; count < minPoolSize; count++) {
                poolFree.add(newConnection());
            }
        } catch (ClassNotFoundException e) {
            throw new ConnectionPoolException("DB driver class not found", e);
        }
    }

    private Connection newConnection() throws ConnectionPoolException {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new ConnectionPoolException("New connection error", e);
        }
    }

    public synchronized Connection getConnection() throws ConnectionPoolException {
        Connection connection;
        if (poolFree.isEmpty()) {
            connection = newConnection();
        } else {
            connection = poolFree.poll();
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new ConnectionPoolException("Set auto commit error", e);
            }
        }
        poolUsed.add(connection);
        return connection;
    }

    public synchronized void retrieveConnection(Connection connection) throws ConnectionPoolException {
        if (connection != null) {
            if (poolUsed.contains(connection)) {
                poolUsed.remove(connection);
                if (getCurrentPoolSize() < minPoolSize) {
                    poolFree.add(connection);
                } else {
                    closeConnection(connection);
                }
            } else {
                throw new ConnectionPoolException("Connection is not in the pool");
            }
        }
    }

    private void closeConnection(Connection connection) throws ConnectionPoolException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new ConnectionPoolException("Connection closing error", e);
        }
    }

    private int getCurrentPoolSize() {
        return poolUsed.size() + poolFree.size();
    }

    public void closeConnectionPool() throws ConnectionPoolException {
        if (!poolUsed.isEmpty()) {
            throw new ConnectionPoolException("Some connections are used");
        } else {
            while (!poolFree.isEmpty()) {
                closeConnection(poolFree.poll());
            }
        }
    }
}
