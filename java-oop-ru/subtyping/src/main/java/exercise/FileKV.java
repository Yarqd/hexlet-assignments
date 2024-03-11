package exercise;

// BEGIN
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class FileKV implements KeyValueStorage {
    private final Path filePath;
    private Map<String, String> data;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = Paths.get(filePath);
        this.data = initialData;
        if (!Files.exists(this.filePath)) {
            try {
                Files.createFile(this.filePath);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            loadFromFile();
        }
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

    private void loadFromFile() {
        try {
            String content = Files.readString(filePath, StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            data = mapper.readValue(content, new TypeReference<Map<String, String>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToFile() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String content = mapper.writeValueAsString(data);
            Files.writeString(filePath, content, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
// END
