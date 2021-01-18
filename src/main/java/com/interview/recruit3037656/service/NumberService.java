package com.interview.recruit3037656.service;

import com.interview.recruit3037656.exception.IncorrectRequestException;
import com.interview.recruit3037656.model.Number;
import com.interview.recruit3037656.repository.NumberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class NumberService {
    private final NumberRepository numberRepository;
    private static Random random = new Random();

    public ArrayList<Number> getAllNumbers() {
        ArrayList<Number> students = new ArrayList<>();
        log.info("Retrieving all numbers...");
        numberRepository.findAll().forEach(students::add);

        return students;
    }

    public Number getNumberById(Long id) {
        log.info(String.format("Getting number by it's id: '%s'", id));

        return numberRepository.findById(id).get();
    }

    public void saveOrUpdate(Number number) {
        log.info(String.format("Saving number: '%s'", number.getNumber()));
        numberRepository.save(number);
    }

    public void delete(Long id) {
        log.info(String.format("Deleting number by it's id: '%s'", id));
        numberRepository.deleteById(id);
    }

    public int calculateAddition(Long id) throws IncorrectRequestException {
        int generatedInt = random.nextInt(100);

        Optional<Number> optionalNumber = Optional.of(numberRepository.findById(id).get());
        if (!optionalNumber.isPresent()) {
            throw new IncorrectRequestException(id);
        }

        Number repositoryNumber = optionalNumber.get();
        int integerFromH2 = Integer.parseInt(repositoryNumber.getNumber());
        log.info(String.format("addition of db value: '%s' and randomly generated number: '%s'", integerFromH2, generatedInt));

        return generatedInt + integerFromH2;
    }
}
