package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class App {
    public static void swapKeyValue (KeyValueStorage storage) {
        Map<String, String> originalData = new HashMap<>(storage.toMap());
        originalData.forEach((key, value) -> storage.set(value, key));
        originalData.keySet().forEach(storage::unset);
    }
}
// END
