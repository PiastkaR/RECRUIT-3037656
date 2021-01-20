package com.interview.recruit3037656.repository;

import com.interview.recruit3037656.model.NumberSource;
import org.springframework.data.repository.CrudRepository;

public interface NumberRepository extends CrudRepository<NumberSource, Long> {
}
