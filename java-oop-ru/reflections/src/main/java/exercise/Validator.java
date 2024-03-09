package exercise;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// BEGIN
public class Validator {
    public static List<String> validate(Address address) {
        List<String> notValidFields = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    Object minLength = field.get(address);
                    if (minLength == null) {
                        notValidFields.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return notValidFields;
    }

    public static Map<String, List<String>> advancedValidate(Object obj) {
        Map<String, List<String>> errorMap = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                List<String> errors = new ArrayList<>();
                if (field.isAnnotationPresent(NotNull.class)) {
                    if (field.get(obj) == null) {
                        errors.add("cannot be null");
                    }
                }
                if (field.isAnnotationPresent(MinLength.class)) {
                    MinLength minLengthAnnotation = field.getAnnotation(MinLength.class);
                    int minLength = minLengthAnnotation.minLength();
                    String minLength = (String) field.get(obj);
                    if (minLength != null && minLength.length() < minLength) {
                        errors.add("length less than " + minLength);
                    }
                }
                if (!errors.isEmpty()) {
                    errorMap.put(field.getName(), errors);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return errorMap;
    }
}
// END
