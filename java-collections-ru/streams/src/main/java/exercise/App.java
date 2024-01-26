package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        return emails.stream()
                .filter(email -> Arrays.asList("gmail.com", "yandex.ru", "hotmail.com").contains(email.substring(email.indexOf('@') + 1)))
                .count();
    }
}
// END
