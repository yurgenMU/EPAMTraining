package hometask4.t02;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordsCounterCharacters {

    public String getWords(String path) {
        StringBuilder sb = new StringBuilder();
        try (Reader reader = new BufferedReader(new FileReader(path))) {
            int data = reader.read();
            char content;
            while (data != -1) {
                content = (char) data;
                sb.append(content);
                data = reader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public void writeIntoFile(String arg, String path) {
        try (Writer writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(arg);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
