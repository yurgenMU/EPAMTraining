package hometask8.t02.DAOImplementations;

import hometask8.t02.DAO.AuthorDAO;
import hometask8.t02.Entities.Author;
import hometask8.t02.Entities.Book;
import hometask8.t02.DAO.LibraryDAO;

import java.sql.*;

/**
 * Implementation of LibraryDAO
 */

public class LibraryDAOImpl implements LibraryDAO {
    private Connection connection;


    public LibraryDAOImpl(Connection connection) {
        this.connection = connection;

    }

    @Override
    public void insert(Book book) throws SQLException {
        AuthorDAO authorDAO = new AuthorDAOImpl(connection);
        authorDAO.insert(book.getAuthor());
        int authorID;
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT ID FROM epamdb.AUTHORS" +
                    " WHERE(FIRSTNAME = '" + book.getAuthor().getFirstName() +
                    "' AND LASTNAME = '" + book.getAuthor().getLastName() + "');");
            rs.next();
            authorID = rs.getInt(1);
            String query2 = "INSERT INTO epamdb.BOOKSINFO (NAME, AUTHORID) VALUES ('" +
                    book.getName() + "', " + authorID + ");";
            st.execute(query2);
        }
    }

    @Override
    public Book get(String name) throws SQLException {
        Author author;
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT epamdb.BOOKSINFO.NAME, epamdb.AUTHORS.FIRSTNAME," +
                    " epamdb.AUTHORS.LASTNAME " +
                    "FROM epamdb.BOOKSINFO JOIN epamdb.AUTHORS ON " +
                    "epamdb.AUTHORS.ID = epamdb.BOOKSINFO.AUTHORID WHERE epamdb.booksinfo.NAME = '" + name + "';");
            rs.next();
            author = new Author(rs.getString(2), rs.getString(3));
            return new Book(rs.getString(1), author);
        }
    }


    @Override
    public void remove(String name) throws SQLException {
        String query = "DELETE FROM epamdb.BOOKSINFO " +
                " WHERE(NAME = '" + name + "');";
        try (Statement st = connection.createStatement()) {
            st.execute(query);
        }
    }
}