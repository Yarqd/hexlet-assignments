package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        // Создаем TreeSet для автоматической сортировки ключей в алфавитном порядке
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        Map<String, String> result = new LinkedHashMap<>(); // Результирующий словарь

        for (String key : keys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (value1 != null && value2 != null) {
                if (value1.equals(value2)) {
                    result.put(key, "unchanged");
                } else {
                    result.put(key, "changed");
                }
            } else if (value1 != null) {
                result.put(key, "deleted");
            } else {
                result.put(key, "added");
            }
        }

        return result;
    }
//END
