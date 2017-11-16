package hometask8.t02.Entities;

/**
 * Class representing the entity which stores two parameter: identifier and value (amount)
 */

public class Book {
    private final String name;
    private final Author author;

    public Author getAuthor() {
        return author;
    }

    public void setText(String text) {

        this.text = text;
    }

    private String text;

    public Book(String name, Author author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }


}