package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public static boolean scrabble(String set, String word) {
        List<Character> characters = new ArrayList<>();
        for (char c : set.toCharArray()) {
            characters.add(c);
        }
        for (char c : word.toCharArray()) {
            if (!characters.contains(c)) {
                return false;
            }
        }

        return true;
        }
//END
