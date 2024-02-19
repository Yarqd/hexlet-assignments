package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// BEGIN
public class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> result = new LinkedHashMap<>(); // Результирующий словарь
        for (String key : data1.keySet()) { // Перебираем ключи из первого словаря
            if (data2.containsKey(key)) { // Если ключ присутствует во втором словаре
                if (data1.get(key).equals(data2.get(key))) { // И значения ключей равны
                    result.put(key, "unchanged"); // Добавляем ключ со значением "unchanged" в результирующий словарь
                } else {
                    result.put(key, "changed"); // Иначе добавляем ключ со значением "changed"
                }
            } else { // Если ключ отсутствует во втором словаре
                result.put(key, "deleted"); // Добавляем ключ со значением "deleted"
            }
        }
        for (String key : data2.keySet()) { // Перебираем ключи из второго словаря
            if (!data1.containsKey(key)) { // Если ключ отсутствует в первом словаре
                result.put(key, "added"); // Добавляем ключ со значением "added" в результирующий словарь
            }
        }
        return result;
    }
//END
