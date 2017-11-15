package hometask8.t02;

public interface AccountDAO {
    /**
     * creates column in MySQL from entity
     *
     * @param a is an instance of entity
     */
    void create(Account a);

    /**
     * Returns account by specified key
     *
     * @param key
     * @return
     */
    Account read(Integer key);

    /**
     * Increases balance of account with the specified key at given number
     *
     * @param key identifier
     * @param inc necessary value
     */
    void update(Integer key, Long inc);
}
