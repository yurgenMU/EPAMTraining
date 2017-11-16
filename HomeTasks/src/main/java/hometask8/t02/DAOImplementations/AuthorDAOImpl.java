package hometask8.t02.DAOImplementations;

import hometask8.t02.Entities.Author;
import hometask8.t02.DAO.AuthorDAO;

import java.sql.*;

public class AuthorDAOImpl implements AuthorDAO {
    private Connection connection;

    public AuthorDAOImpl(Connection connection) {
        this.connection = connection;

    }

    @Override
    public void insert(Author author) throws SQLException {
        String firstName = author.getFirstName();
        String lastName = author.getLastName();
        String query = "INSERT INTO epamdb.AUTHORS (FIRSTNAME, LASTNAME)" +
                "SELECT * FROM (SELECT '" +
                firstName + "', '" + lastName + "') AS tmp " +
                "WHERE NOT EXISTS (SELECT FIRSTNAME FROM epamdb.AUTHORS WHERE FIRSTNAME = '" + firstName
                + "' AND LASTNAME = '" + lastName + "') LIMIT 1 ;";
        try (Statement st = connection.createStatement()) {
            st.execute(query);
        }

    }

    @Override
    public Author get(String firstName, String lastName) throws SQLException {
        Author author;
        String query = "SELECT FIRSTNAME, LASTNAME FROM epamdb.AUTHORS " +
                " WHERE(FIRSTNAME = '" + firstName + "' AND LASTNAME = '" + lastName + "');";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            rs.next();
            author = new Author(rs.getString(1), rs.getString(2));
        }
        return author;
    }


    @Override
    public void remove(String firstName, String lastName) throws SQLException {
        String query = "DELETE FROM epamdb.AUTHORS " +
                " WHERE('" + firstName + "' = FIRSTNAME AND LASTNAME = '" + lastName + "');";
        try (Statement st = connection.createStatement()) {
            st.execute(query);
        }
    }


}
