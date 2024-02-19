package exercise;

import java.util.LinkedHashMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>(data1.keySet()); // Создаем TreeSet для автоматической сортировки ключей
        keys.addAll(data2.keySet()); // Добавляем все ключи из обоих множеств

        Map<String, String> result = new LinkedHashMap<>(); // Результирующий словарь
        for (String key : keys) {
            if (data1.containsKey(key) && data2.containsKey(key)) {
                if (data1.get(key).equals(data2.get(key))) {
                    result.put(key, "unchanged");
                } else {
                    result.put(key, "changed");
                }
            } else if (data1.containsKey(key)) {
                result.put(key, "deleted");
            } else {
                result.put(key, "added");
            }
        }
        return result;
    }
//END
