package com.arthurgurov.jcommons.model;

/**
 * {@link Copiable} object provides a special method that copies the object.
 */
public interface Copiable<E> {

    /**
     * Copy the object.
     *
     * @return a instance of the object.
     */
    E copy();
}
