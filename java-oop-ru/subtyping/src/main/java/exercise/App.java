package exercise;

import java.util.Map;
import java.util.LinkedHashMap;

public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> map = storage.toMap();
        Map<String, String> swappedMap = new LinkedHashMap<>();

        for (Map.Entry<String, String> entry : map.entrySet()) {
            swappedMap.put(entry.getValue(), entry.getKey());
        }

        storage.setAll(swappedMap);
    }
}
