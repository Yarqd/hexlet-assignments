package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map getWordCount(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return new HashMap<>();
        }
        String[] words = sentence.split(" ");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    public static String toString(Map<String, Integer> wordsCount) {
        StringBuilder result = new StringBuilder("{");
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            result.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
        }
        result.append("}");
        return result.toString();
    }
}
//END
