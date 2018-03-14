package com.arthurgurov.jcommons.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Objects that matter only as the combination of their attributes. Two value objects with the same
 * values for all their attributes are considered equal.
 */
public abstract class ValueObject<VO extends ValueObject, V> extends BusinessObject
    implements Copiable<VO>, Serializable {

    @Override
    public String asFormattedString() {
        return asString();
    }

    public String asString() {
        return String.valueOf(getValue());
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return Objects.equals(getValue(), ((ValueObject) obj).getValue());
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(getValue());
    }

    public abstract V getValue();
}
