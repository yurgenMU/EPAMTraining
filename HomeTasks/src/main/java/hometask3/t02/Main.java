package hometask3.t02;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale russian = new Locale("ru");
        Locale english = new Locale("eng");
        Locale actucalLocale = null;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Choose language" + "\n" + "English" + "\n" + "Русский");
            String f = scanner.nextLine();
            if (f.equalsIgnoreCase("English")) {
                System.out.println(getQuestionsList("questions", english));
                actucalLocale = english;
            } else if (f.equalsIgnoreCase("Русский")) {
                System.out.println(getQuestionsList("questions", russian));
                actucalLocale = russian;
            }
            while (true) {
                String number = scanner.nextLine();
                if (number.equalsIgnoreCase("Exit") || number.equalsIgnoreCase("Выход"))
                    System.exit(0);
                ResourceBundle resourceBundle = ResourceBundle.getBundle("answers", actucalLocale, new UTF8Control());
                int bundleSize = resourceBundle.keySet().size() - 1;
                if (Integer.parseInt(number) <= bundleSize)
                    System.out.println(resourceBundle.getString(number));
                else
                    System.out.println(resourceBundle.getString(String.valueOf((resourceBundle.keySet().size()))));


            }
        }
    }

    public static String getQuestionsList(String baseName, Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName, locale, new UTF8Control());
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : resourceBundle.keySet()) {
            stringBuilder.append(s).append(".").append(resourceBundle.getString(s)).append("\n");
        }
        return stringBuilder.toString();
    }

}
