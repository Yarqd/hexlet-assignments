package exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    private static final String TEST_FILE_PATH = "src/test/resources/file";

    @BeforeEach
    public void beforeEach() throws Exception {
        Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
    }

    @Test
    void testSetAndGet() {
        FileKV storage = new FileKV(TEST_FILE_PATH, new HashMap<>());
        storage.set("key", "value");
        assertEquals("value", storage.get("key", null));
    }

    @Test
    void testUnset() {
        FileKV storage = new FileKV(TEST_FILE_PATH, new HashMap<>());
        storage.set("key", "value");
        storage.unset("key");
        assertNull(storage.get("key", null));
    }

    @Test
    void testGetDefaultValue() {
        FileKV storage = new FileKV(TEST_FILE_PATH, new HashMap<>());
        assertNull(storage.get("key", null));
        assertEquals("default", storage.get("key", "default"));
    }

    @Test
    void testToMap() {
        Map<String, String> initialData = new HashMap<>();
        initialData.put("key1", "value1");
        initialData.put("key2", "value2");
        FileKV storage = new FileKV(TEST_FILE_PATH, initialData);
        Map<String, String> data = storage.toMap();
        assertEquals(initialData, data);
    }
    // END
}
