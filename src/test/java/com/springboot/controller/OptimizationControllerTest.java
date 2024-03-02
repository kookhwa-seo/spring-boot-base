package com.springboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OptimizationControllerTest{
    @Autowired
    private MockMvc mvc;

    private static String BASE_URL = "/api/optimization";

    @Test
    public void findAllWithCoveringIndex() throws Exception {
        mvc.perform(get(BASE_URL+"/covering")).andExpect(status().isOk());
    }
    @Test
    public void findTop2ByOrderByIdAsc() throws Exception {
        mvc.perform(get(BASE_URL)).andExpect(status().isOk());
    }
}