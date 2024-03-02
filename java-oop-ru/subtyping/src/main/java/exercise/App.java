package exercise;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashMap;


// BEGIN
public class App {
    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> data = storage.toMap();
        Map<String, String> newData = new HashMap<>();
        for (Entry<String, String> entry : data.entrySet()) {
            newData.put(entry.getValue(), entry.getKey());
        }
        for (Entry<String, String> entry : newData.entrySet()) {
            storage.set(entry.getKey(), entry.getValue());
        }
    }
}
// END
