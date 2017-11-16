package hometask5.t02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Property {
    private String path;


    public Property(String path) throws NoPropertyFileException {
        this.path = path;
    }

    public Properties getProperties() throws NoPropertyFileException {
        Properties properties = new Properties();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            properties.load(bufferedReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
