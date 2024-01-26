package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static long getCountOfFreeEmails(List<String> emails) {
        String em1 = "gmail.com";
        String em2 = "yandex.ru";
        String em3 = "hotmail.com";
        long count = emails.stream()
                .filter(s -> s.contains(em1) && s.contains(em2) && s.contains(em3))
                .count();
        return count;
    }
// END
