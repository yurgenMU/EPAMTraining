package hometask3.t01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        CrazyLogger crazyLogger = new CrazyLogger();
        String path = "HomeTasks/src/main/resources/log.txt";
        crazyLogger.addIntoLog("first message");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        crazyLogger.addIntoLog("second message");
        crazyLogger.saveLog(path);
        System.out.println(crazyLogger.findLog("first message", path));
        System.out.println(crazyLogger.findLog("second message", path));
        System.out.println(crazyLogger.findLog("third message", path));


    }
}
