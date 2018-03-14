package com.arthurgurov.jcommons.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Objects that have a distinct identity that runs through time and different representations.
 */
public abstract class Entity<I> extends Aggregate implements Identifiable<I> {

    @Override
    protected final void doEquals(final EqualsBuilder builder, final Aggregate that) {
        final I thisIdentity = getIdentity();
        final I thatIdentity = ((Identifiable<I>) that).getIdentity();

        if (thisIdentity == null || thatIdentity == null) {
            builder.appendSuper(false);
        } else {
            builder.append(thisIdentity, thatIdentity);
        }
    }

    @Override
    protected final void doHashCode(final HashCodeBuilder builder) {
        builder.append(getIdentity());
    }

    @Override
    public String asFormattedString() {
        final I identity = getIdentity();

        return identity != null ? identity.toString() : "INVALID";
    }
}
