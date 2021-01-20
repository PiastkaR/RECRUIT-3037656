package com.interview.recruit3037656.controller;

import com.interview.recruit3037656.IntegrationBaseTest;
import com.interview.recruit3037656.repository.NumberRepository;
import com.interview.recruit3037656.service.NumberService;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class NumberSourceControllerIntegrationTest extends IntegrationBaseTest {

    @MockBean
    private NumberService numberService;

    @MockBean
    private NumberRepository numberRepository;

    @Test
    public void shouldReturnAddedValues() throws Exception {
        mockMvc.perform(get("/interviewApp/addition/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}