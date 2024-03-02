package exercise;

// BEGIN
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.HashMap;


public class FileKV implements KeyValueStorage {
    private Map<String, String> data = new HashMap<>();
    private final Path filepath;
    private final Map<String, String> data;

    public FileKV(Path filepath) {
        this.filepath = filepath;
        this.data = new HashMap<>();
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);
    }

    @Override
    public void unset(String key) {
        data.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return data;
    }

    @Override
    public void save() throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Map.Entry<String, String> entry : data.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        }
    }
}

// END
