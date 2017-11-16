package hometask8.t02;

import hometask8.t02.DAO.AuthorDAO;
import hometask8.t02.DAO.LibraryDAO;
import hometask8.t02.DAOImplementations.AuthorDAOImpl;
import hometask8.t02.DAOImplementations.LibraryDAOImpl;
import hometask8.t02.Entities.Author;
import hometask8.t02.Entities.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        try {
            String initPath = "Hometasks/src/main/resources/hometask8.t02/init.sql";
            Service service = new Service(initPath);
            service.init();
            Connection connection = service.getConnection();
            AuthorDAO authorDAO = new AuthorDAOImpl(connection);
            LibraryDAO libraryDAO = new LibraryDAOImpl(connection);
            insertInitials(authorDAO, libraryDAO);
            libraryDAO.get("Вишнёвый сад");
            libraryDAO.insert(new Book("Дядя Ваня", authorDAO.get("Антон", "Чехов")));
            libraryDAO.remove("Метель");
        } catch (ConnectionPoolException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertInitials(AuthorDAO authorDAO, LibraryDAO libraryDAO) {
        Author chekhov = new Author("Антон", "Чехов");
        Author pushkin = new Author("Александр", "Пушкин");
        Book metel = new Book("Метель", pushkin);
        Book sad = new Book("Вишнёвый сад", chekhov);
        Author[] authors = {chekhov, pushkin};
        Book[] books = {metel, sad};
        Arrays.stream(authors).forEach(x -> {
            try {
                authorDAO.insert(x);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        Arrays.stream(books).forEach(x -> {
            try {
                libraryDAO.insert(x);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}
