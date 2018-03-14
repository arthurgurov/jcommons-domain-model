package com.arthurgurov.jcommons.model.security;

public interface SecureObject<U> {

    boolean isAccessAllowed(AccessType type, U user);

    default boolean isReadAccessAllowed(final U user) {
        return isAccessAllowed(AccessType.READ, user);
    }

    default boolean isWriteAccessAllowed(final U user) {
        return isAccessAllowed(AccessType.WRITE, user);
    }

    default boolean isDeleteAccessAllowed(final U user) {
        return isAccessAllowed(AccessType.DELETE, user);
    }
}
