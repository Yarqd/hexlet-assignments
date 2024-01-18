package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public static boolean scrabble(String set, String word) {
    String lowerSet = set.toLowerCase();
    String lowerWord = word.toLowerCase();
    if (word > set) {
        return false;
        }
        List<String> listSet = new ArrayList<>();
    for (var i = 0; i < lowerSet.length; i++) {
        listSet[i] = lowerSet.charAt(i);
        }
    for (var i = 0; i < lowerWord.length; i++) {
        char  checkChar = lowerWord.charAt(i);
        for (var j = 0; j < listSet.length; j++) {
            if (!listSet.contains(checkChar)) {
                return false;
            } else {
                listSet.remove(j)
        }
    }
        return true;
}
//END
