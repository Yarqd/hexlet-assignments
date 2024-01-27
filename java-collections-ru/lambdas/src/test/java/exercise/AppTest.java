package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    public void testNlargeArrayImage() {
        String[][] originalImage = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"}
        };
        String[][] expectedEnlargedImage = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", " ", " ", " ", " ", " ", " ", "*"},
                {"*", " ", " ", " ", " ", " ", " ", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", " ", " ", " ", " ", " ", " ", "*"},
                {"*", " ", " ", " ", " ", " ", " ", "*"}
        };
        String[][] actualEnlargedImage = ImageProcessor.nlargeArrayImage(originalImage);
        assertThat(actualEnlargedImage).isEqualTo(expectedEnlargedImage);
    }
}
// END
