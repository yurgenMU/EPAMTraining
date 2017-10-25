package hometask4.t01;


import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Statistics {
    public static Map<String, Integer> getStatistics(String keyWords, String allWords) {
        String[] keyWordsArray = keyWords
                .replaceAll("[\\r\\n]", "\t")
                .replaceAll("[\\t]+", " ")
                .split(" ");
        Map<String, Integer> statistics = new TreeMap<>();
        for (String word : keyWordsArray) {
            int count = 0;
            Pattern pattern = Pattern.compile("(?![A-Za-z])*" + word + "(?![a-z])");
            Matcher matcher = pattern.matcher(allWords);
            while (matcher.find()) {
                count++;
                statistics.put(matcher.group(0), count);
            }
        }
        return statistics;
    }


}
