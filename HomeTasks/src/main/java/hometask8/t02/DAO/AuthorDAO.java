package hometask8.t02.DAO;

import hometask8.t02.Entities.Author;

import java.sql.SQLException;

public interface AuthorDAO {

    /**
     * @param author
     */
    void insert(Author author) throws SQLException;

    /**
     * @param firstName
     * @param lastName
     * @return
     */
    Author get(String firstName, String lastName) throws SQLException;

    /**
     * @param firstName
     * @param lastName
     * @return
     */
    void remove(String firstName, String lastName) throws SQLException;


}
