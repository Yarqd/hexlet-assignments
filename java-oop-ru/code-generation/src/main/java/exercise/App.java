package exercise;

import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

// BEGIN
public class App {

    public static void save(Path path, Car car) {
        Objects.requireNonNull(path, "Path must not be null");
        Objects.requireNonNull(car, "Car must not be null");

        try {
            String json = car.serialize();
            Files.write(path, json.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Car extract(Path path) {
        Objects.requireNonNull(path, "Path must not be null");

        try {
            String json = new String(Files.readAllBytes(path));
            return Car.unserialize(json);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
// END
