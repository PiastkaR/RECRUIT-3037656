package com.interview.recruit3037656.service;

import com.interview.recruit3037656.exception.IncorrectRequestException;
import com.interview.recruit3037656.model.NumberSource;
import com.interview.recruit3037656.model.NumberSourceDto;
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

    public ArrayList<NumberSource> getAllNumbers() {
        ArrayList<NumberSource> numbers = new ArrayList<>();
        log.info("Retrieving all numbers...");
        numberRepository.findAll().forEach(numbers::add);

        return numbers;
    }

    public NumberSource getNumberById(Long id) {
        log.info(String.format("Getting number by it's id: '%s'", id));

        return numberRepository.findById(id).get();
    }

    public void saveOrUpdate(NumberSourceDto numberSourceDto) {
        NumberSource numberSource = convertFromNumberSourceDto(numberSourceDto);

        log.info(String.format("Saving number: '%s'", numberSource.getNumberValue()));
        numberRepository.save(numberSource);
    }

    private NumberSource convertFromNumberSourceDto(NumberSourceDto numberSourceDto){
        NumberSource numberSource = new NumberSource();
        numberSource.setId(numberSourceDto.getNumberId());
        numberSource.setNumberValue(numberSourceDto.getNumberValue());

        //TODO easier with modelMapper i.e modelMapper.getConfiguration()
        //                .setMatchingStrategy(MatchingStrategies.LOOSE);
        //		UserLocationDTO userLocationDTO = modelMapper
        //                .map(user, UserLocationDTO.class);

        return numberSource;
    }

    private NumberSourceDto convertToNumberSourceDto(NumberSource numberSource) {
        NumberSourceDto numberSourceDto = new NumberSourceDto();
        numberSourceDto.setNumberId(numberSource.getId());
        numberSourceDto.setNumberValue(numberSource.getNumberValue());

        return numberSourceDto;
    }

    public void delete(Long id) {
        log.info(String.format("Deleting number by it's id: '%s'", id));
        numberRepository.deleteById(id);
    }

    public int calculateAddition(Long id) throws IncorrectRequestException {
        int generatedInt = random.nextInt(100);

        Optional<NumberSource> optionalNumber = numberRepository.findById(id);
        if (optionalNumber.isEmpty())
        {
            throw new IncorrectRequestException(id);
        }

        NumberSource repositoryNumberSource = optionalNumber.get();
        int integerFromH2 = Integer.parseInt(repositoryNumberSource.getNumberValue());
        log.info(String.format("addition of db value: '%s' and randomly generated number: '%s'", integerFromH2, generatedInt));

        return generatedInt + integerFromH2;
    }
}
