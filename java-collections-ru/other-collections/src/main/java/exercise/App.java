package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Set<String> keys = new TreeSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        Map<String, String> result = new LinkedHashMap<>();

        for (String key : keys) {
            Object value1 = data1.get(key);
            Object value2 = data2.get(key);

            if (value1 == null && value2 == null) {
                // Если оба значения равны null, то это неизмененный ключ
                result.put(key, "unchanged");
            } else if (value1 == null) {
                // Если значение только во втором словаре, то это добавленный ключ
                result.put(key, "added");
            } else if (value2 == null) {
                // Если значение только в первом словаре, то это удаленный ключ
                result.put(key, "deleted");
            } else if (!value1.equals(value2)) {
                // Если значения ключей отличаются, то это измененный ключ
                result.put(key, "changed");
            } else {
                // Если значения равны, то это неизмененный ключ
                result.put(key, "unchanged");
            }
        }

        return result;
    }
}
//END
