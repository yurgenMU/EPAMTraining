package hometask3.t01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class CrazyLogger {
    private StringBuilder stringBuilder;

    public CrazyLogger() {
        stringBuilder = new StringBuilder();
    }

    public void addIntoLog(String message) {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-YYYY HH:mm");
        stringBuilder.append(time.format(formatter)).append(" - ").append(message).append("\n");
    }

    public void saveLog(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String find(String substr, StringBuilder sb) {
        Pattern pattern = Pattern.compile(substr);
//        try (BufferedReader)
//        String a = stringBuilder.
        return null;
    }
}
