package com.arthurgurov.jcommons.model.support;

import com.arthurgurov.jcommons.exception.UnexpectedException;
import com.arthurgurov.jcommons.model.Aggregate;
import com.arthurgurov.jcommons.model.Ref;
import com.arthurgurov.jcommons.model.exception.ModelValidationException;
import com.arthurgurov.jcommons.model.util.ClassUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.text.MessageFormat;

public final class RefValidator {

    private RefValidator() {
        // prevent class instantiation
    }

    public static void validate(final Aggregate aggregate, final Class<? extends ModelValidationException> e) {
        ClassUtils.getAllDeclaredFields(aggregate.getClass())
            .forEach(field -> validateField(field, aggregate, e));
    }

    private static void validateField(
        final Field field, final Aggregate aggregate, final Class<? extends ModelValidationException> e) {

        if (field.getType() != Ref.class) {
            return;
        }

        final Ref<?> ref = getFieldValue(field, aggregate);

        if (ref.isMandatory() && !ref.hasValue()) {
            throw initValidationException(field, aggregate, e);
        }
    }

    private static Ref getFieldValue(final Field field, final Aggregate aggregate) {
        final boolean accessible = field.isAccessible();

        try {
            if (!accessible) {
                field.setAccessible(true);
            }

            return (Ref) field.get(aggregate);
        } catch (final IllegalAccessException ex) {
            throw new UnexpectedException(MessageFormat.format(
                "Unable to access field {0} of {1}", field.getName(), aggregate), ex);
        } finally {
            if (!accessible) {
                field.setAccessible(false);
            }
        }
    }

    private static ModelValidationException initValidationException(
        final Field field, final Aggregate aggregate, final Class<? extends ModelValidationException> e) {

        try {
            return e.getConstructor(aggregate.getClass(), String.class)
                .newInstance(aggregate, buildExceptionsMessage(field));

        } catch (final ReflectiveOperationException ex) {
            throw new UnexpectedException("Constructor is missing!");
        }
    }

    private static String buildExceptionsMessage(final Field field) {
        final String[] tokens = StringUtils.splitByCharacterTypeCamelCase(field.getName());
        return StringUtils.capitalize(String.join(" ", tokens).toLowerCase()) + " is missing!";
    }
}
