package exercise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.assertj.core.api.Assertions.assertThat;

class FileKVTest {

    private static Path filePath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        Files.deleteIfExists(filePath);
    }

    @Test
    void testFileKV() {
        Map<String, String> initialData = new HashMap<>();
        initialData.put("key1", "value1");
        initialData.put("key2", "value2");

        FileKV storage = new FileKV(filePath.toString(), initialData);
        assertThat(storage.get("key1", "")).isEqualTo("value1");
        assertThat(storage.get("key2", "")).isEqualTo("value2");
        assertThat(storage.get("key3", "default")).isEqualTo("default");

        storage.set("key3", "value3");
        assertThat(storage.get("key3", "")).isEqualTo("value3");

        storage.unset("key3");
        assertThat(storage.get("key3", "default")).isEqualTo("default");

        Map<String, String> expectedData = new HashMap<>();
        expectedData.put("key1", "value1");
        expectedData.put("key2", "value2");
        assertThat(storage.toMap()).isEqualTo(expectedData);
    }
}
