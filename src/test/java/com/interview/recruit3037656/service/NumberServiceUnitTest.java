package com.interview.recruit3037656.service;

import com.interview.recruit3037656.exception.IncorrectRequestException;
import com.interview.recruit3037656.model.Number;
import com.interview.recruit3037656.repository.NumberRepository;
import com.interview.recruit3037656.tools.TestNumberFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.interview.recruit3037656.tools.TestNumberFactory.FIRST_VALUE;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class NumberServiceUnitTest {

    @Mock
    private NumberRepository numberRepository;

    @InjectMocks
    private NumberService numberService;

    @Test
    void calculateAddition() throws IncorrectRequestException {
        // Arrange
        Number expectedNumber = TestNumberFactory.createNumber();
        int expectedInteger = Integer.parseInt(expectedNumber.getNumber());

        when(numberRepository.findById(anyLong())).thenReturn(java.util.Optional.of(expectedNumber));

        //Act
        int actualAddition = numberService.calculateAddition(FIRST_VALUE);

        // Assert
        assertTrue(expectedInteger < actualAddition);
    }
}