package com.arthurgurov.jcommons.model.exception;

import java.text.MessageFormat;

public abstract class ValueObjectValidationException extends ModelValidationException {

    public ValueObjectValidationException(final Integer code, final String message, final Object value) {
        super(code, message, buildDetails(value));
    }

    private static String buildDetails(final Object value) {
        return value == null ? "Value is blank"
            : MessageFormat.format("Bad value: {0}", value);
    }
}
