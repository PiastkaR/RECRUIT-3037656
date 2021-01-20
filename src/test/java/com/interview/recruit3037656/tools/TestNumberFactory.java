package com.interview.recruit3037656.tools;

import com.interview.recruit3037656.model.NumberSource;

public class TestNumberFactory {
    public static final Long FIRST_VALUE = 1l;
    public static NumberSource createNumber() {
        return NumberSource.builder()
                .id(FIRST_VALUE)
                .numberValue("456")
                .build();
    }
}
