import java.util.Map;
import java.util.HashMap;

public class MyKeyValueStorage implements KeyValueStorage {
    private Map<String, String> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public void setAll(Map<String, String> map) {
        storage.putAll(map);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }
}
