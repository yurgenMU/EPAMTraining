package hometask5.t01;

import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        FileBrowser fileBrowser = new FileBrowser();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                String s = scanner.nextLine();
                String path;

                if (s.substring(0, 2).equalsIgnoreCase("ls") && (s.length() != 2)) {
                    path = s.split(" ", 2)[1];
                    fileBrowser.search(path);
                } else if (s.equals("ls")) {
                    fileBrowser.search(fileBrowser.getActualDirectory());
                    continue;
                } else if (s.substring(0, 2).equalsIgnoreCase("cd")) {
                    path = s.split(" ", 2)[1];
                    fileBrowser.changeDirectory(path);
                } else if (s.substring(0, 5).equalsIgnoreCase("mkdir")) {
                    String name = s.split(" ", 2)[1];
                    fileBrowser.createFile(name);
                } else if (s.substring(0, 4).equalsIgnoreCase("get")) {
                    String name = s.split(" ", 2)[1];
                    fileBrowser.readFromFile(name);
                } else if (s.substring(0, 5).equalsIgnoreCase("write")) {
                    String name = s.split(" ")[1];
                    String text = s.split(" ")[2];
                    System.out.println(text);
                    fileBrowser.writeIntoFile(name, text);
                } else if (s.substring(0, 7).equals("remove")) {
                    String name = s.split(" ", 2)[1];
                    try {
                        fileBrowser.removeFile(name);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (NoSuchDirectoryException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
