package com.interview.recruit3037656.controller;

import com.interview.recruit3037656.exception.IncorrectRequestException;
import com.interview.recruit3037656.model.NumberSource;
import com.interview.recruit3037656.model.NumberSourceDto;
import com.interview.recruit3037656.service.NumberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(path = "/interviewApp")
public class NumberController {
    private final NumberService numberService;

    @GetMapping("/addition/{id}")
    public int getAddition(@PathVariable("id") Long id) {
        int addition = 0;

        try {
            addition = numberService.calculateAddition(id);
        } catch (IncorrectRequestException exception) {
            log.error(exception.getMessage());
        }

        return addition;
    }

    @GetMapping("/numbers")
    public List<NumberSource> getAllNumbers() {
        return numberService.getAllNumbers();
    } //Tu lepiej zwracac interfejs (List niz implementacje)...

    @GetMapping("/number/{id}")
    public NumberSource getNumberById(@PathVariable("id") Long id) {
        return numberService.getNumberById(id);
    }

    @DeleteMapping("/number/{id}")
    public void deleteNumber(@PathVariable("id") Long id) {
        numberService.delete(id);
    }

    @PostMapping("/number")
    public Long saveNumber(@RequestBody NumberSourceDto numberSourceDto) {
        numberService.saveOrUpdate(numberSourceDto);

        return numberSourceDto.getNumberId();  //TODO do zamiany na DTO...
    }
}
