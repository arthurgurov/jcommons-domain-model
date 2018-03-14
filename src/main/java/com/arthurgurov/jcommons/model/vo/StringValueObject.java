package com.arthurgurov.jcommons.model.vo;

public abstract class StringValueObject<VO extends StringValueObject<VO>> extends SimpleValueObject<VO, String> {

    protected StringValueObject(final String value) {
        super(value);
    }

    protected StringValueObject(final StringValueObject<VO> valueObject) {
        super(valueObject);
    }
}
