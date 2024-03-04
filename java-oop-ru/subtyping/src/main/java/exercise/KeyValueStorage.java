package exercise;

import java.util.Map;

public interface KeyValueStorage {
    void clear();
    void setAll(Map<String, String> map);
    Map<String, String> toMap();
}
