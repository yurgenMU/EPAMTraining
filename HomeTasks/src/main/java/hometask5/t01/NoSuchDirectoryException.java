package hometask5.t01;

import java.io.FileNotFoundException;

public class NoSuchDirectoryException extends FileNotFoundException {

    NoSuchDirectoryException() {
        System.out.println("Directory does not exist");
    }
}
