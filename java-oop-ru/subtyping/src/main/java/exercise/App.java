package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
import java.util.Map;
import java.util.HashMap;

public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> newData = new HashMap<>();
        Map<String, String> data = storage.toMap();
        for (Map.Entry<String, String> entry : data.entrySet()) {
            newData.put(entry.getValue(), entry.getKey());
        }
        // Заменяем значения в хранилище на обратные
        for (Map.Entry<String, String> entry : newData.entrySet()) {
            storage.set(entry.getKey(), entry.getValue());
        }
    }
}
// END
