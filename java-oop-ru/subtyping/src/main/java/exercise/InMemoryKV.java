package exercise;

import java.util.Map;
import java.util.HashMap;

public class InMemoryKV implements KeyValueStorage {
    private final Map<String, String> dataMap;

    public InMemoryKV(Map<String, String> initialData) {
        this.dataMap = initialData;
    }

    @Override
    public void set(String key, String value) {
        dataMap.put(key, value);
    }

    @Override
    public void unset(String key) {
        dataMap.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return dataMap.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(dataMap);
    }

    @Override
    public void setAll(Map<String, String> map) {
        dataMap.clear();
        dataMap.putAll(map);
    }
}
