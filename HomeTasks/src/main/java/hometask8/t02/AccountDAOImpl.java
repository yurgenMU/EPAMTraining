package hometask8.t02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Implementation of AccountDAO
 */

public class AccountDAOImpl implements AccountDAO {
    ConnectionPool connectionPool;
    Connection connection;
    Statement statement;


    public AccountDAOImpl() {
        try {
            connectionPool = new ConnectionPool();
            connection = connectionPool.getConnection();
            statement = connection.createStatement();
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Method checks if table exists in database and creates necessary table if it doesn't exist
     */

    public void checkTable() {
        try {
            statement.execute("CREATE TABLE IF NOT EXISTS ACCOUNTS (ID INT NOT NULL," +
                    " AMOUNT BIGINT NOT NULL, PRIMARY KEY(ID));");
        } catch (SQLException e) {
            System.out.println("Error while creating account " + e.getMessage());
        }
    }

    @Override
    public void create(Account a) {
        try {
            checkTable();
            statement.execute("INSERT INTO ACCOUNTS VALUES (" + a.getId() + "," + a.getValue() + ");");
        } catch (SQLException e) {
            System.out.println("Error while creating account " + e.getMessage());
        }


    }

    @Override
    public Account read(Integer key) {
        Long val = null;
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT AMOUNT FROM ACCOUNTS WHERE ID = " + key + ";");
            if (rs.next()) {
                val = rs.getLong(1);
            } else {
                return null;
            }
            rs.close();

        } catch (SQLException e) {
            return null;
        }
        return new Account(key, val);
    }

    @Override
    public void update(Integer key, Long inc) {
        try {
            Statement st = connection.createStatement();
            Account account = read(key);
            if (account == null) {
                create(new Account(key, inc));
            } else {
                st.execute("UPDATE ACCOUNTS SET AMOUNT = " + (account.getValue() + inc) + " WHERE ID = " + account.getId());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}