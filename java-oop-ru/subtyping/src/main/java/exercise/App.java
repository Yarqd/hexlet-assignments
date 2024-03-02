package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> newData = new HashMap<>();
        Map<String, String> data = storage.toMap();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            newData.put(entry.getValue(), entry.getKey());
        }
        // Удаляем дублирующиеся ключи
        newData = removeDuplicates(newData);
        // Заменяем значения в хранилище на обратные
        for (Map.Entry<String, String> entry : newData.entrySet()) {
            storage.set(entry.getKey(), entry.getValue());
        }
    }

    private static Map<String, String> removeDuplicates(Map<String, String> map) {
        Map<String, String> uniqueMap = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            // Если значение уже есть в uniqueMap, не добавляем его
            if (!uniqueMap.containsKey(entry.getKey())) {
                uniqueMap.put(entry.getKey(), entry.getValue());
            }
        }
        return uniqueMap;
    }
}
// END
