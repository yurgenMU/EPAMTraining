package hometask8.t02.DAO;

import hometask8.t02.Entities.Book;

import java.sql.SQLException;

public interface LibraryDAO {
    /**
     * creates column in MySQL from entity
     *
     * @param book is an instance of entity
     */
    void insert(Book book) throws SQLException;

    /**
     * Returns account by specified key
     *
     * @param name
     * @return
     */
    Book get(String name) throws SQLException;


    /**
     * @param name
     */
    void remove(String name) throws SQLException;
}
