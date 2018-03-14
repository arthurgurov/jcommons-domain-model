package com.arthurgurov.jcommons.model;

/**
 * {@link Identifiable} object has a unique identity that can be used to calculate a
 * <code>hashCode()</code> or check objects quality.
 */
public interface Identifiable<I> {

    /**
     * Returns a unique identity of the object. It can be used to calculate a
     * <code>hashCode()</code> or check objects equality.
     *
     * @return a unique identity of the object.
     */
    I getIdentity();
}
