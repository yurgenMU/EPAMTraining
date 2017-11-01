package hometask5.t01;

public class UnknownCommandException extends RuntimeException {

    public UnknownCommandException() {
        System.out.println("Such command does not exist");
    }
}
