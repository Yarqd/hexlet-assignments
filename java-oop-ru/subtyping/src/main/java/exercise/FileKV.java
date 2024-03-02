package exercise;

// BEGIN
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

public class FileKV implements KeyValueStorage {
    private final Path filePath;
    private Map<String, String> data;

    public FileKV(Path filePath, Map<String, String> initialData) {
        this.filePath = filePath;
        this.data = initialData;
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
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return data;
    }

    private void saveToFile() {
        try {
            String content = Utils.serialize(data);
            Files.writeString(filePath, content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFromFile() {
        try {
            String content = Files.readString(filePath);
            data = Utils.unserialize(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// END
