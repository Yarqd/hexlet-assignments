package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public static boolean scrabble(String set, String word) {
    String lowerSet = set.toLowerCase();
    String lowerWord = word.toLowerCase();
    if (word.length() > set.length()) {
        return false;
    }
    List<String> listSet = new ArrayList<>();
    for (var i = 0; i < lowerSet.length(); i++) {
        String x = String.valueOf(lowerSet.charAt(i));
        listSet.add(i, x);
    }
    for (var i = 0; i < lowerWord.length(); i++) {
        //char  checkChar = lowerWord.charAt(i);
        String z = String.valueOf(lowerWord.charAt(i));
        // z = Взятая буква из слова
        for (var j = 0; j < listSet.size(); j++) {
            if (!listSet.contains(z)) {
                return false;
            } else {
                listSet.remove(i);
                break;
            }
        }
    }
    return false;
}
}
//END
