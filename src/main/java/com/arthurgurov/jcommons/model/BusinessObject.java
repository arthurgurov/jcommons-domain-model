package com.arthurgurov.jcommons.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Base class for all business objects.
 */
public abstract class BusinessObject implements Formattable {

    protected static <E> Set<E> getUnmodifiable(final Set<E> set) {
        return new HashSet<>(set);
    }

    protected static <E> List<E> getUnmodifiable(final List<E> list) {
        return new ArrayList<>(list);
    }

    protected static <K, V> Map<K, V> getUnmodifiable(final Map<K, V> map) {
        return new HashMap<>(map);
    }

    /**
     * Returns a string representation of the object for debug purposes.
     *
     * @return a string representation of the object.
     *
     * @deprecated Deprecated in order to prevent usage of this method for both debugging and
     * business purposes. If you need to get a string representation of a business object, please
     * use a dedicated method e.g. <code>asString()</code> or <code>asRawString()</code>.
     */
    @Override
    @Deprecated
    public final String toString() {
        return asFormattedString();
    }

    @Override
    public String asFormattedString() {
        return getClass().getSimpleName();
    }
}