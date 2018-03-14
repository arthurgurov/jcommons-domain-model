package com.arthurgurov.jcommons.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * A cluster of domain objects that can be treated as a single unit.
 */
public abstract class Aggregate extends BusinessObject {

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        final EqualsBuilder builder = new EqualsBuilder();
        doEquals(builder, (Aggregate) obj);

        return builder.isEquals();
    }

    protected void doEquals(final EqualsBuilder builder, final Aggregate that) {
        builder.appendSuper(false);
    }

    @Override
    public final int hashCode() {
        final HashCodeBuilder builder = new HashCodeBuilder();
        doHashCode(builder);

        return builder.toHashCode();
    }

    protected void doHashCode(final HashCodeBuilder builder) {
        builder.appendSuper(super.hashCode());
    }
}
