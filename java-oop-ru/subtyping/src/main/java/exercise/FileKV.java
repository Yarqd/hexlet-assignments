package exercise;

// BEGIN
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class FileKV implements KeyValueStorage {
    private final Path filepath;
    private final Map<String, String> dataMap;

    public FileKV(Path filepath) {
        this.filepath = filepath;
        this.dataMap = new HashMap<>();
    }

    @Override
    public String get(String key, String defaultValue) {
        return dataMap.getOrDefault(key, defaultValue);
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
    public Map<String, String> toMap() {
        return new HashMap<>(dataMap);
    }

    @Override
    public void save() throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(filepath)) {
            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        }
    }

    @Override
    public void clear() {
        dataMap.clear();
    }
}

// END
