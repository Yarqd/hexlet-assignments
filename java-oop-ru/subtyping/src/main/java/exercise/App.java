package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> originalData = storage.toMap();
        storage.toMap().forEach((key, value) -> storage.set(value, key));
        originalData.keySet().forEach(storage::unset);
    }
}
// END
