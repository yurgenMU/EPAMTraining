package hometask4.t01;

import java.util.Map;

public class WordsCounterDemo {

    public static void main(String[] args) {
        KeyWordsCounter keyWordsCounter = new KeyWordsCounter();
        String sourcePath = "HomeTasks/src/main/java/hometask4/t01/WordsCounterDemo.java";
        String targetPath = "HomeTasks/src/main/java/hometask4/t01/answer.txt";
        String keywordsPath = "HomeTasks/src/main/java/hometask4/t01/keyWords.txt";
        Map<String, Integer> statistics = Statistics.getStatistics(keyWordsCounter.getWords(keywordsPath)
                , keyWordsCounter.getWords(sourcePath));
        String s = format(statistics);
        System.out.println(s);
        keyWordsCounter.writeIntoFile(s, targetPath);

    }

    public static String format(Map<String, Integer> map) {
        StringBuilder sb = new StringBuilder();
        for (String s : map.keySet())
            sb.append(s).append(" - ").append(map.get(s)).append("\n");
        return sb.toString();
    }
}
