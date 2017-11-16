package hometask3.t01;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
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

    public String findLog(String patternText, String logPath) {
        String[] logText = new String[0];
        File file;
        try (FileReader reader = new FileReader(file = new File(logPath))) {
            char[] buffer = new char[(int) file.length()];
            reader.read(buffer, 0, (int) file.length());
            logText = new String(buffer).trim().split("\\r\\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Pattern pattern = Pattern.compile(patternText);
        StringBuilder foundLog = new StringBuilder();
        for (String str : logText) {
            Matcher m = pattern.matcher(str);
            if (m.find()) {
                foundLog.append(str).append("\r\n");
            }
            return foundLog.toString();
        }
        return "Not found";
    }
}
