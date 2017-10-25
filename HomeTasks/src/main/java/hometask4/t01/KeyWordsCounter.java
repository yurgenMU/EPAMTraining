package hometask4.t01;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyWordsCounter {

    public String getWords(String path) {
        StringBuilder sb = new StringBuilder();
        try (InputStream inputStream = new FileInputStream(path)) {
            int data = inputStream.read();
            char content;
            while (data != -1) {
                content = (char) data;
                sb.append(content);
                data = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void writeIntoFile(String arg, String path) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            fileOutputStream.write(arg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
