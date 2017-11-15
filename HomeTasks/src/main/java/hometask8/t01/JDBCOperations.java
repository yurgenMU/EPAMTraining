package hometask8.t01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class JDBCOperations {
    private String initPath;
    private String propertiesPath;
    private Connection connection = null;
    private Statement statement = null;
    private String tableName;


    public void init() throws SQLException {
        connection = getDBConnection();
        statement = connection.createStatement();
        createInitialState(statement);
    }

    public void destroy() throws SQLException {
        if (statement != null) {
            statement.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    public void setInitPath(String initPath) {
        this.initPath = initPath;
    }


    public void setPropertiesPath(String propertiesPath) {
        this.propertiesPath = propertiesPath;
    }


    private Connection getDBConnection() {
        Properties properties = ConnectionProperties.getProperties(propertiesPath);
        Connection dbConnection = null;
        try {
            Class.forName(properties.getProperty("db.driver"));
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(
                    properties.getProperty("db.url"), properties.getProperty("db.username"),
                    properties.getProperty("db.password"));
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;

    }


    public void select(String query) throws SQLException {
        System.out.println("\"SELECT\" query is executing");
        System.out.println("");
        ResultSet rs = statement.executeQuery(query);
        ResultSetMetaData rsmd = rs.getMetaData();
        tableName = rsmd.getTableName(1);
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    public void update(String query) throws SQLException {
        System.out.println("\"UPDATE\" query is executing");
        statement.execute(query);
        select("SELECT*FROM " + tableName);
        System.out.println("Table " + tableName + " updated \n");

    }

    public void remove(String name) throws SQLException {
        System.out.println("\"REMOVE\" query is executing");
        statement.execute("DROP TABLE " + name + ";");
        System.out.println("Table " + tableName + " removed \n");
    }

    public void insert(String query) throws SQLException {
        System.out.println("\"INSERT\" query is executing");
        statement.execute(query);
        select("SELECT * FROM " + tableName + ";");
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
