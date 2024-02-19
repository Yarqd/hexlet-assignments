package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {

    public static String getForwardedVariables(String content) {
        return Arrays.stream(content.split("\n"))  // Разбиваем содержимое файла на строки
                .filter(line -> line.trim().startsWith("environment")) // Фильтруем строки, начинающиеся с "environment"
                .flatMap(line -> {  // Преобразуем строки в поток переменных окружения
                    String[] parts = line.split("\"");  // Разбиваем строку по кавычкам
                    if (parts.length >= 2) { // Проверяем, что есть кавычки
                        String envList = parts[1]; // Получаем список переменных окружения в кавычках
                        return Arrays.stream(envList.split(",")); // Разбиваем список на отдельные переменные и создаем поток
                    }
                    return Stream.empty(); // Возвращаем пустой поток, если нет переменных окружения в кавычках
                })
                .filter(variable -> variable.trim().startsWith("X_FORWARDED_")) // Фильтруем только переменные с префиксом X_FORWARDED_
                .map(variable -> { // Убираем префикс из имен переменных
                    String[] parts = variable.split("=");
                    return parts[0].substring("X_FORWARDED_".length()) + "=" + parts[1];
                })
                .collect(Collectors.joining(",")); // Собираем переменные в строку, разделяя запятыми
    }

    public static void main(String[] args) {
        String content = "[program:prepare]\n" +
                "command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make prepare'\n" +
                "autorestart=false\n" +
                "environment=\"X_FORWARDED_MAIL=tirion@google.com,X_FORWARDED_HOME=/home/tirion,language=en\"\n" +
                "\n" +
                "[program:http_server]\n" +
                "command=sudo -HEu tirion /bin/bash -c 'cd /usr/src/app && make environment'\n" +
                "environment=\"key5=value5,X_FORWARDED_var3=value,key6=value6\"";

        String result = App.getForwardedVariables(content);
        System.out.println(result); // => "MAIL=tirion@google.com,HOME=/home/tirion,var3=value"
    }
}
//END
