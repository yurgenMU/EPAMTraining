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

                if (s.substring(0, 2).equals("ls") && (s.length() != 2)) {
                    path = s.split(" ", 2)[1];
                    fileBrowser.search(path);
                }
                if (s.equals("ls")) {
                    fileBrowser.search(fileBrowser.getActualDirectory());
                    continue;
                }
                if (s.substring(0, 2).equals("cd")) {
                    path = s.split(" ", 2)[1];
                    fileBrowser.changeDirectory(path);
                }
                if (s.substring(0, 5).equals("mkdir")) {
                    String name = s.split(" ", 2)[1];
                    fileBrowser.createFile(name);
                }
                if (s.substring(0, 4).equals("read")) {
                    String name = s.split(" ", 2)[1];
                    fileBrowser.readFromFile(name);
                }
                if (s.substring(0, 5).equals("write")) {
                    String name = s.split(" ")[1];
                    String text = s.split(" ")[2];
                    System.out.println(text);
                    fileBrowser.writeIntoFile(name, text);
                }
                if (s.substring(0, 7).equals("remove")) {
                    String name = s.split(" ", 2)[1];
                    fileBrowser.removeFile(name);
                }
            }
        } catch (UnknownCommandException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
