package com.arthurgurov.jcommons.model.exception;

import com.arthurgurov.jcommons.exception.ApplicationException;
import com.arthurgurov.jcommons.exception.ValidationException;

public abstract class ModelValidationException extends ApplicationException implements ValidationException {

    public ModelValidationException(final Integer code, final String message, final String details) {
        super(code, message, details);
    }

    public ModelValidationException(final Integer code, final String message, final Throwable cause) {
        super(code, message, cause);
    }

    public ModelValidationException(final Integer code, final String message, final String details, final Throwable cause) {
        super(code, message, details, cause);
    }
}
