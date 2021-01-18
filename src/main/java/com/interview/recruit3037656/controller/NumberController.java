package com.interview.recruit3037656.controller;

import com.interview.recruit3037656.exception.IncorrectRequestException;
import com.interview.recruit3037656.model.Number;
import com.interview.recruit3037656.service.NumberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/interviewApp")
public class NumberController {
    private final NumberService numberService;

    @GetMapping("/addition/{id}")
    private int getAddition(@PathVariable("id") Long id) {
        int addition = 0;

        try {
            addition = numberService.calculateAddition(id);
        } catch (IncorrectRequestException exception) {
            log.error(exception.getMessage());
        }

        return addition;
    }

    @GetMapping("/numbers")
    private ArrayList<Number> getAllNumbers() {
        return numberService.getAllNumbers();
    }

    @GetMapping("/number/{id}")
    private Number getNumberById(@PathVariable("id") Long id) {
        return numberService.getNumberById(id);
    }

    @DeleteMapping("/number/{id}")
    private void deleteNumber(@PathVariable("id") Long id) {
        numberService.delete(id);
    }

    @PostMapping("/number")
    private Long saveNumber(@RequestBody Number number) {
        numberService.saveOrUpdate(number);

        return number.getId();
    }

    @ExceptionHandler
    public ResponseEntity handleOtherException(final Exception exception) {
        log.error("Unexpected exception was encountered. ", exception);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }
}
