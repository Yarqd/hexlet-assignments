package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;

// BEGIN
public class App {
    public static String getForwardedVariables(String content) {
        String result = "";
        String[] lines = content.split("\n");
        for (String line : lines) {
            if (line.startsWith("environment=")) {
                String[] envVars = line.split("=")[1].split(",");
                for (String envVar : envVars) {
                    String[] keyValue = envVar.split("=");
                    if (keyValue[0].startsWith("X\_FORWARDED\_")) {
                        result += keyValue[0].replace("X\_FORWARDED\_", "") + "=" + keyValue[1] + ",";
                    }
                }
            }
        }
        return result.substring(0, result.length() - 1); // Удаляем последний символ запятой
    }
}
//END
