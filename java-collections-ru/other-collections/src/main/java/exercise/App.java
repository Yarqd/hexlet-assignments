package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>(); // Результирующий словарь
        // Перебираем ключи из первого словаря
        for (String key : data1.keySet()) {
            // Если ключ присутствует во втором словаре
            if (data2.containsKey(key)) {
                // Проверяем равенство значений
                if (data1.get(key).equals(data2.get(key))) {
                    result.put(key, "unchanged"); // Значения равны
                } else {
                    result.put(key, "changed"); // Значения отличаются
                }
            } else {
                result.put(key, "deleted"); // Ключ отсутствует во втором словаре
            }
        }
        // Перебираем ключи из второго словаря
        for (String key : data2.keySet()) {
            // Если ключ отсутствует в первом словаре
            if (!data1.containsKey(key)) {
                result.put(key, "added"); // Ключ добавлен
            }
        }
        return result;
    }
//END
