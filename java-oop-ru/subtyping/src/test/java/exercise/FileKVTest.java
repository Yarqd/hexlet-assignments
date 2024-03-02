package exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws IOException {
        Files.deleteIfExists(filepath); // Удаляем файл перед каждым запуском теста
    }

    // BEGIN
    @Test
    public void testFileKV() throws IOException {
        // Arrange
        Map<String, String> testData = new HashMap<>();
        testData.put("key1", "value1");
        testData.put("key2", "value2");

        // Act
        String serializedData = Utils.serialize(testData);
        Utils.writeFile(filepath.toString(), serializedData);

        String fileContent = Utils.readFile(filepath.toString());
        Map<String, String> deserializedData = Utils.unserialize(fileContent);

        // Assert
        assertEquals(testData, deserializedData);
    }
    // END
}
