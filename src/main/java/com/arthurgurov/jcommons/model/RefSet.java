package com.arthurgurov.jcommons.model;

import java.util.Collection;
import java.util.HashSet;

public final class RefSet<T> extends HashSet<T> implements Formattable {

    public RefSet() {
        super();
    }

    public RefSet(int initialCapacity) {
        super(initialCapacity);
    }

    public RefSet(Collection<? extends T> c) {
        super(c);
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
        return super.toString();
    }
}
