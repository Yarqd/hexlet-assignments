package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map getWordCount(String sentence) {
        String[] x = sentence.split(" "); // Создал массив со словами
        Map<String, Integer> map = new HashMap<>(); //Создал результирующую map
        for (var i = 0; i < x.length; i++){
            if (map.containsKey(x[i])) { //Если в мапе есть ключ (слово) то
                int newKey = map.get(x[i]) + 1;
                map.put(x[i], newKey);
            } else {
                map.put(x[i], 1);
            }
        }
        return map;
    }
    public static String toString(Map<String, Integer> map) {
        var result = new StringBuilder();
        result.append("{");
        result.append("\n");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.append("  ");
            result.append(entry.getKey());
            result.append(": ");
            result.append(entry.getValue());
            result.append("\n");
        }
        result.append("}");
        return result.toString();
    }
}
}
//END
