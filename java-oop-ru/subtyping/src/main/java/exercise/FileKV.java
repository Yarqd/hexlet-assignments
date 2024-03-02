package exercise;

// BEGIN
import java.util.Map;

public class FileKV implements KeyValueStorage {
    private String filePath;

    public FileKV(String filePath, Map<String, String> initialData) {
        this.filePath = filePath;
        String content = Utils.serialize(initialData);
        Utils.writeFile(filePath, content);
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> data = Utils.unserialize(Utils.readFile(filePath));
        data.put(key, value);
        String content = Utils.serialize(data);
        Utils.writeFile(filePath, content);
    }

    @Override
    public void unset(String key) {
        Map<String, String> data = Utils.unserialize(Utils.readFile(filePath));
        data.remove(key);
        String content = Utils.serialize(data);
        Utils.writeFile(filePath, content);
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> data = Utils.unserialize(Utils.readFile(filePath));
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(filePath));
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
