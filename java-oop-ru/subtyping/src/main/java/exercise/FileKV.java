package exercise;

// BEGIN
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class FileKV implements KeyValueStorage {
    private final Path filePath;
    private final Map<String, String> data;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = Path.of(filePath);
        this.data = new HashMap<>(initialData);
        saveToFile();
    }

    private void saveToFile() {
        Utils.writeFile(filePath, Utils.serialize(data));
    }

    private void loadFromFile() {
        String content = Utils.readFile(filePath);
        this.data.clear();
        this.data.putAll(Utils.unserialize(content));
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);
        saveToFile();
    }

    @Override
    public void unset(String key) {
        data.remove(key);
        saveToFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        loadFromFile();
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        loadFromFile();
        return new HashMap<>(data);
    }
}
// END
