package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {
    public static int getCountOfFreeEmails(List<String> emails) {
        int count = 0;
        for (String email : emails) {
            if (isFreeDomain(email)) {
                count++;
            }
        }

        return count;
    }

    private static boolean isFreeDomain(String email) {
        String[] parts = email.split("@");
        if (parts.length == 2) {
            String domain = parts[1];
            return domain.equals("gmail.com") || domain.equals("yandex.ru") || domain.equals("hotmail.com");
        }
        return false;
    }
}
// END
