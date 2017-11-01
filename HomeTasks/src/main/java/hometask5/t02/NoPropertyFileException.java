package hometask5.t02;

import java.io.FileNotFoundException;

public class NoPropertyFileException extends FileNotFoundException {

    public NoPropertyFileException() {
        super("Property file with this name not found");
    }
}
