package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> originalData = storage.toMap();
        Map<String, String> newData = new HashMap<>();
        for (Entry<String, String> entry : originalData.entrySet()) {
            newData.put(entry.getValue(), entry.getKey());
        }
        storage.unsetAll();
        for (Entry<String, String> entry : newData.entrySet()) {
            storage.set(entry.getKey(), entry.getValue());
        }
    }
}
// END
