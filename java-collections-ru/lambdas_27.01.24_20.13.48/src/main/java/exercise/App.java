package exercise;

import java.util.Arrays;

// BEGIN
public class App{
public static String[][] enlargeArrayImage(String[][] arr) {
    int rows = arr.length;
    int columns = arr[0].length;
    String[][] result = new String[rows * 2][columns * 2];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            String pixel = arr[i][j];
            result[2 * i][2 * j] = pixel;
            result[2 * i + 1][2 * j] = pixel;
            result[2 * i][2 * j + 1] = pixel;
            result[2 * i + 1][2 * j + 1] = pixel;
        }
    }
    return result;
}
// END
