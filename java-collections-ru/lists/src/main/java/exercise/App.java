package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public static boolean scrabble(String symbols, String word) {
        String lowerCaseStr = word.toLowerCase();
        if (symbols.contains(lowerCaseStr)) {
            return true;
        } else {
            return false;
        }
}
//END
