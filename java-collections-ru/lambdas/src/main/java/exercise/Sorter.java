package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

// BEGIN
public class Sorter {
    public static List<String> takeOldestMans(List<Map<String, String>> users) {
        List<String> oldestMans = new ArrayList<>();
        users.stream()
                .filter(person -> "male".equals(person.get("gender")))
                .sorted(Comparator.comparing(person -> LocalDate.parse(person.get("birthday"))))
                .forEach(user -> oldestMans.add(user.get("name")));
        return oldestMans;
    }
// END
