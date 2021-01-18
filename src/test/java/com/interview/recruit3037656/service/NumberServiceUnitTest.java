package com.interview.recruit3037656.service;

import com.interview.recruit3037656.exception.IncorrectRequestException;
import com.interview.recruit3037656.model.Number;
import com.interview.recruit3037656.repository.NumberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NumberServiceUnitTest {
    private static final Long FIRST_VALUE = 1l;

    @Mock
    private NumberRepository numberRepository;

    @InjectMocks
    private NumberService numberService;

    @Captor
    private ArgumentCaptor<Integer> randomNumberCaptor;

    @Test
    void calculateAddition() throws IncorrectRequestException {
        // Arrange
        Number expectedNumber = createNumber();
        int expectedInteger = Integer.parseInt(expectedNumber.getNumber());

        when(numberRepository.findById(anyLong())).thenReturn(java.util.Optional.of(expectedNumber));

        //Act
        int actualAddition = numberService.calculateAddition(FIRST_VALUE);

        // Assert
        assertEquals(expectedInteger + 50, actualAddition);
    }

    private Number createNumber() {
        return Number.builder()
                .id(FIRST_VALUE)
                .number("456")
                .build();
    }
}