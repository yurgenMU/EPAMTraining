package hometask3.t03;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public void printAnswer() {
        Pattern p = Pattern.compile("([А-Я][^.?!]*?)?(?<!\\\\w)(?i)(([Рр]ис.[ ]?[\\d]))(?!\\\\w)[^.?!]*?[.?!]");
        String text = getText();
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }

    }

    public boolean isOrder() {
        String text = getText();
        Pattern p = Pattern.compile("(\\([Рр]ис.[ ]?[\\d])");
        Matcher m = p.matcher(text);
        List<Integer> indexes = new ArrayList<>();
        while (m.find()) {
            int n = Integer.parseInt(m.group(0).split("\\.[ ]?")[1]);
            indexes.add(n);
            for (Integer i : indexes) {
                if (i > n)
                    return false;
                break;
            }
        }
        return true;
    }

    private String getText() {
        StringBuilder stringBuilder = new StringBuilder();
        String text = "HomeTasks/src/main/resources/Java.SE.03.Information handling_task_attachment.txt";
        try {
            Files.readAllLines(Paths.get(text), Charset.forName("UTF-8")).stream()
                    .forEach(s -> stringBuilder.append(s));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}
