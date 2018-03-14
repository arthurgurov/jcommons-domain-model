package com.arthurgurov.jcommons.model;

public abstract class Ref<T> implements Formattable {

    private transient T value;

    public static <T> Ref<T> mandatory() {
        return new MandatoryRef<>();
    }

    public static <T> Ref<T> optional() {
        return new OptionalRef<>();
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public boolean hasValue() {
        return value != null;
    }

    public abstract boolean isMandatory();

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
        return hasValue() ? getValue().toString() : null;
    }

    private static class MandatoryRef<T> extends Ref<T> {

        public boolean isMandatory() {
            return true;
        }
    }

    private static class OptionalRef<T> extends Ref<T> {

        public boolean isMandatory() {
            return false;
        }
    }
}
