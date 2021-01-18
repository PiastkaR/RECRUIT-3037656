package com.interview.recruit3037656.controller;

import com.interview.recruit3037656.ComponentBaseTest;
import com.interview.recruit3037656.repository.NumberRepository;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@AutoConfigureMockMvc
class NumberControllerComponentTest extends ComponentBaseTest {

    @MockBean
    private NumberRepository numberRepository;

}