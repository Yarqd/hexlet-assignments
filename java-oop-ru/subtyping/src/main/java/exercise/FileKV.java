package exercise;

import java.util.Map;
import java.util.HashMap;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileKV implements KeyValueStorage {
    private final Path filePath;
    private final Map<String, String> dataMap;

    public FileKV(String fileName, Map<String, String> initialData) {
        this.filePath = Path.of(fileName);
        this.dataMap = initialData;
    }

    @Override
    public void set(String key, String value) {
        dataMap.put(key, value);
        saveToFile();
    }

    @Override
    public void unset(String key) {
        dataMap.remove(key);
        saveToFile();
    }

    @Override
    public String get(String key, String defaultValue) {
        return dataMap.getOrDefault(key, defaultValue);
    }

    @Override
    public void clear() {
        dataMap.clear();
        saveToFile();
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(dataMap);
    }

    private void saveToFile() {
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            for (Map.Entry<String, String> entry : dataMap.entrySet()) {
                writer.write(entry.getKey() + "=" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception appropriately
        }
    }

    @Override
    public void setAll(Map<String, String> map) {
        // Реализация метода
    }
}
