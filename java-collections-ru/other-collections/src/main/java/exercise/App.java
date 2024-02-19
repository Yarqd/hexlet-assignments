package exercise;

import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>(); // Результирующий словарь
        // Получаем объединение ключей из обоих словарей
        for (String key : data1.keySet()) {
            if (data2.containsKey(key)) {
                if (data1.get(key).equals(data2.get(key))) {
                    result.put(key, "unchanged");
                } else {
                    result.put(key, "changed");
                }
            } else {
                result.put(key, "deleted");
            }
        }
        for (String key : data2.keySet()) {
            if (!data1.containsKey(key)) {
                result.put(key, "added");
            }
        }
        return result;
    }
//END
