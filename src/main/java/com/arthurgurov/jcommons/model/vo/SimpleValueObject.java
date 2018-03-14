package com.arthurgurov.jcommons.model.vo;

import com.arthurgurov.jcommons.model.ValueObject;

public abstract class SimpleValueObject<VO extends SimpleValueObject<VO, V>, V> extends ValueObject<VO, V> {

    private final V value;

    protected SimpleValueObject(final V value) {
        this.value = value;
    }

    protected SimpleValueObject(final SimpleValueObject<VO, V> valueObject) {
        this.value = valueObject.value;
    }

    @Override
    public V getValue() {
        return value;
    }
}
