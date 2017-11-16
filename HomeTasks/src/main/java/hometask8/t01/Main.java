package hometask8.t01;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        JDBCOperations operations = new JDBCOperations();
        operations.setInitPath("Hometasks/src/main/resources/hometask8/t01/init.sql");
        operations.setPropertiesPath("Hometasks/src/main/resources/hometask8/t01/db.properties");
        try {
            operations.init();
            operations.select("SELECT * FROM PLAYERS;");
            operations.update("UPDATE PLAYERS SET FIRSTNAME = 'ИГАРЬ' WHERE id = 1;");
            operations.select("SELECT FIRSTNAME, LASTNAME FROM PLAYERS WHERE id = 2");
            operations.insert("INSERT INTO PLAYERS (FirstName,LastName) VALUES('Nemanja','Matic');");
            operations.remove("Players;");
            operations.destroy();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
