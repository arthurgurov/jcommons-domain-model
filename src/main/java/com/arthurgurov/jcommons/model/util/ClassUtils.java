package com.arthurgurov.jcommons.model.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ClassUtils {

    private static final Map<Class<?>, Field[]> FIELDS_CACHE = new HashMap<>();

    /**
     * Prevent instantiation.
     */
    private ClassUtils() {
        // empty
    }

    /**
     * Get all fields of the class including all parent classes in hierarchy of the specified
     * class.
     *
     * @param type the class to inspect
     *
     * @return a list which contains all fields of the specified class
     */
    public static List<Field> getAllDeclaredFields(final Class<?> type) {
        final List<Field> fields = new ArrayList<>();
        fetchAllDeclaredFields(fields, type);

        return fields;
    }

    /**
     * Fetch all class fields recursively.
     *
     * @param fields the list to add found fields
     * @param type   the class to inspect
     */
    private static void fetchAllDeclaredFields(final List<Field> fields, final Class<?> type) {
        // Try to get fields from the cache
        Field[] cached = FIELDS_CACHE.get(type);
        if (cached != null) {
            Collections.addAll(fields, cached);

            return;
        }

        synchronized (FIELDS_CACHE) {

            cached = FIELDS_CACHE.get(type);
            if (cached != null) {
                Collections.addAll(fields, cached);

                return;
            }

            // Introspect the given type
            Collections.addAll(fields, type.getDeclaredFields());

            if (type.getSuperclass() != null) {
                fetchAllDeclaredFields(fields, type.getSuperclass());
            }

            // Save fields to the cache
            FIELDS_CACHE.put(type, fields.toArray(new Field[0]));
        }
    }

    /**
     * Get annotation (including all superclasses).
     *
     * @param clazz           the class to inspect
     * @param annotationClass the class of an annotation to search
     * @param <A>             the annotation class
     *
     * @return the annotation instance
     */
    public static <A extends Annotation> A getAnnotation(final Class<?> clazz, final Class<A> annotationClass) {
        Class<?> targetClass = clazz;

        do {
            final A annotation = targetClass.getAnnotation(annotationClass);
            if (annotation != null) {
                return annotation;
            }
        } while ((targetClass = targetClass.getSuperclass()) != null);

        return null;
    }
}
