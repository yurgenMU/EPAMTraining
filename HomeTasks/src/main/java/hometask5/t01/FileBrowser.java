package hometask5.t01;

import java.io.*;
import java.util.Scanner;

public class FileBrowser {
    public String getActualDirectory() {
        return actualDirectory;
    }

    String actualDirectory = "C:/";

    public static void search(String path) {
        File f = new File(path);
        if (!f.isDirectory())
            System.out.println("Это файл");
        else {
            for (File file : f.listFiles()) {
                System.out.println(file.getName());
            }
        }
    }

    public void changeDirectory(String directory) throws NoSuchDirectoryException {
        if (!(directory.split("/")[0].equals("c:") || directory.split("/")[0].equals("C:"))) {
            StringBuilder sb = new StringBuilder(actualDirectory);
            sb.append("/").append(directory);
            actualDirectory = sb.toString();
        } else
            actualDirectory = directory;

    }

    public void createFile(String name) throws IOException {
        String path = new StringBuilder(actualDirectory).append("/").append(name).append(".txt").toString();
        System.out.println(path);
        File file = new File(path);
        if (file.createNewFile()) {
            System.out.println("File is created!");
        } else {
            System.out.println("File already exists.");
        }
    }

    public void removeFile(String name) throws IOException {
        File file = new File(actualDirectory + "/" + name);
        if (file.delete()) {
            System.out.println(file.getName() + " is deleted!");
        } else {
            throw new RemovalException();
        }
    }

    public String readFromFile(String name) throws RuntimeException {
        String path = actualDirectory + "/" + name;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {
            String sCurrentLine;
            while ((sCurrentLine = bufferedReader.readLine()) != null) {
                sb.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String text = sb.toString();
        System.out.println(text);
        return text;
    }

    public void writeIntoFile(String name, String text) {
        String path = actualDirectory + "/" + name;
        String actualText = readFromFile(name);
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)))) {
            StringBuilder stringBuilder = new StringBuilder(actualText);
            stringBuilder.append(text);
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
