package hometask4.t02;

import hometask4.t01.Statistics;
import hometask4.t01.WordsCounterDemo;

import java.util.Map;

public class CounterDemo {
    public static void main(String[] args) {
        WordsCounterCharacters wordsCounterCharacters = new WordsCounterCharacters();
        String sourcePath = "HomeTasks/src/main/java/hometask4/t02/CounterDemo.java";
        String targetPath = "HomeTasks/src/main/java/hometask4/t02/answer.txt";
        String keywordsPath = "HomeTasks/src/main/java/hometask4/t01/keyWords.txt";
        Map<String, Integer> statistics = Statistics.getStatistics(wordsCounterCharacters.getWords(keywordsPath)
                , wordsCounterCharacters.getWords(sourcePath));
        String s = WordsCounterDemo.format(statistics);
        System.out.println(s);
        wordsCounterCharacters.writeIntoFile(s, targetPath);

    }


}
