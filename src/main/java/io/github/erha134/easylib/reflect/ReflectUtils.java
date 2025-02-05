package io.github.erha134.easylib.reflect;

import io.github.erha134.easylib.string.StringFormatter;
import io.github.erha134.easylib.annotation.Alias;
import io.github.erha134.easylib.annotation.Ignore;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReflectUtils {
    public static <T> T convertToBean(Class<T> clazz, Map<String, Object> map) {
        T instance = newInstance(clazz);
        for (Field f : clazz.getDeclaredFields()) {
            if (f.isAnnotationPresent(Ignore.class)) {
                continue;
            }

            int mod = f.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod) || Modifier.isTransient(mod)) {
                continue;
            }

            if (!f.isAccessible()) {
                f.setAccessible(true);
            }

            String name = f.getName();
            Alias alias = f.getAnnotation(Alias.class);
            if (alias != null) {
                name = alias.value();
            }

            Class<?> type = f.getType();
            Object value = map.get(name);

            if (value == null) {
                continue;
            }

            if (!value.getClass().isAssignableFrom(type)) {
                continue;
            }

            if (type.isPrimitive() || type == List.class || type == Map.class) {
                try {
                    f.set(instance, value);  // FIXME
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(StringFormatter.format("Failed to set value of field {} of class {}",
                            name, clazz.getCanonicalName()), e);
                }
            } else {
                try {
                    f.set(instance, convertToBean(type, (Map<String, Object>) value));
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(StringFormatter.format("Failed to set value of field {} of class {}",
                            name, clazz.getCanonicalName()), e);
                }
            }
        }

        return instance;
    }

    public static <T> Map<String, Object> convertToMap(T instance) {
        Class<T> clazz = (Class<T>) instance.getClass();

        Map<String, Object> map = new LinkedHashMap<>();
        for (Field f : clazz.getDeclaredFields()) {
            if (f.isAnnotationPresent(Ignore.class)) {
                continue;
            }

            int mod = f.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod) || Modifier.isTransient(mod)) {
                continue;
            }

            if (!f.isAccessible()) {
                f.setAccessible(true);
            }

            String name = f.getName();
            Alias alias = f.getAnnotation(Alias.class);
            if (alias != null) {
                name = alias.value();
            }

            Class<?> type = f.getType();

            if (type.isPrimitive() || type == List.class || type == Map.class) {
                try {
                    map.put(name, f.get(instance));  // FIXME
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(StringFormatter.format("Failed to get value of field {} of class {}",
                            name, clazz.getCanonicalName()), e);
                }
            } else {
                try {
                    map.put(name, convertToMap(f.get(instance)));
                } catch (IllegalAccessException e) {
                    throw new IllegalArgumentException(StringFormatter.format("Failed to get value of field {} of class {}",
                            name, clazz.getCanonicalName()), e);
                }
            }
        }

        return map;
    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException(StringFormatter.format("Failed to create instance of class {}",
                    clazz.getCanonicalName()), e);
        }
    }
}
