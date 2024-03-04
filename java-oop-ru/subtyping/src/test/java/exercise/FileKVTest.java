package exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import com.fasterxml.jackson.databind.ObjectMapper;

class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    @Test
    void testSetAndGet() {
        KeyValueStorage storage = new FileKV(filepath.toString(), new HashMap<>());
        storage.set("key", "value");
        assertEquals("value", storage.get("key", ""));
    }

    @Test
    void testUnset() {
        KeyValueStorage storage = new FileKV(filepath.toString(), new HashMap<>());
        storage.set("key", "value");
        storage.unset("key");
        assertEquals("", storage.get("key", ""));
    }

    @Test
    void testSaveAndLoadFromFile() {
        KeyValueStorage storage = new FileKV(filepath.toString(), new HashMap<>());
        storage.set("key", "value");

        // Создаем новый объект FileKV, который загружает данные из файла
        KeyValueStorage newStorage = new FileKV(filepath.toString());
        assertEquals("value", newStorage.get("key", ""));
    }
}
