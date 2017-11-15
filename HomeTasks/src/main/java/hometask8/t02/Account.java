package hometask8.t02;

/**
 * Class representing the entity which stores two parameter: identifier and value (amount)
 */

public class Account {
    private int id;
    private Long value;

    public Account(int id, Long value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Long getValue() {
        return value;
    }


}