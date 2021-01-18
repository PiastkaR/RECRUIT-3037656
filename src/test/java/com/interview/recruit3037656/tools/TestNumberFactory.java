package com.interview.recruit3037656.tools;

import com.interview.recruit3037656.model.Number;

public class TestNumberFactory {
    public static final Long FIRST_VALUE = 1l;
    public static Number createNumber() {
        return Number.builder()
                .id(FIRST_VALUE)
                .number("456")
                .build();
    }
}
