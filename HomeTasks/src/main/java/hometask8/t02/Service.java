package hometask8.t02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class Service {
    private ConnectionPool connectionPool;
    private final String initPath;
    private Statement statement;

    public Service(String initPath) throws ConnectionPoolException, SQLException {
        this.initPath = initPath;
        statement = getConnection().createStatement();
    }

    public Connection getConnection() throws ConnectionPoolException {
        if (connectionPool == null)
            connectionPool = new ConnectionPool();
        return connectionPool.getConnection();
    }

    public void finishConnection(Connection connection) throws ConnectionPoolException {
        if (connectionPool != null)
            connectionPool.retrieveConnection(connection);
    }

    public void init() throws SQLException {
        createInitialState(statement);
    }

    private void createInitialState(Statement statement) throws SQLException {
        String createTableSQL = getInitQuieries(initPath);
        Arrays.stream(createTableSQL.split(";")).filter(x -> (!x.equals("\n"))).forEach(x -> {
            try {
                statement.execute(x);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }


    private String getInitQuieries(String path) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            List lines = Files.readAllLines(Paths.get(path));
            lines.stream().forEach(line -> stringBuilder.append(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
