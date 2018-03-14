package com.arthurgurov.jcommons.model;

public interface Updatable<E> {

    void patch(E source);

    void update(E source);
}
