package com.interview.recruit3037656.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
@RequiredArgsConstructor
public class RandNumber {
    private int value;
    private Random random = new Random();
}
