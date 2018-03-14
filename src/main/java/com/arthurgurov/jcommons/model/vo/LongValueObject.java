package com.arthurgurov.jcommons.model.vo;

public abstract class LongValueObject<VO extends LongValueObject<VO>> extends SimpleValueObject<VO, Long> {

    protected LongValueObject(final Long value) {
        super(value);
    }

    protected LongValueObject(final LongValueObject<VO> valueObject) {
        super(valueObject);
    }
}
