package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class scrabble {
    public static boolean scrabble(String set, String word) {
        String lowerWord = word.toLowerCase();
        if (word.length() > set.length()) {
            return false;
        }
        List<String> listSet = new ArrayList<>();
        for (var i = 0; i < set.length(); i++) {
            String x = String.valueOf(set.charAt(i));
            listSet.add(i, x);
        }
        for (var i = 0; i < lowerWord.length(); i++) {
            String z = String.valueOf(lowerWord.charAt(i));
            for (var j = 0; j < listSet.size(); j++) {
                if (!listSet.contains(z)) {
                    return false;
                } else {
                    int index = listSet.indexOf(z);
                    listSet.remove(index);
                    break;
                }
            }
        }
        return true;
    }
}
//END
