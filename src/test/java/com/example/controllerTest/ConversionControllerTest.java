package com.example.controllerTest;

import com.example.controller.ConversionController;
import com.example.service.ConversionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(ConversionController.class)
public class ConversionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConversionService service;

    @Test
    public void test_doConversion_Success() throws Exception {

        mockMvc.perform(get("/amphora/v1/convert")
                .param("sourceUnit", "MT")
                .param("targetUnit", "BBL")
                .param("sourceAmount", "200"))
                .andExpect(status().isOk());
    }

    @Test
    public void test_doConversion_InvalidParam() throws Exception {

        mockMvc.perform(get("/amphora/v1/convert")
                        .param("targetUnit", "BBL")
                        .param("sourceAmount", "200"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void test_doConversion_InvalidEndpoint() throws Exception {

        mockMvc.perform(get("/amphora/convert")
                        .param("sourceUnit", "MT")
                        .param("targetUnit", "BBL")
                        .param("sourceAmount", "200"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void test_doConversion_InvalidConversion() throws Exception {

        mockMvc.perform(get("/amphora/convert")
                        .param("sourceUnit", "MT")
                        .param("targetUnit", "MT")
                        .param("sourceAmount", "200"))
                .andExpect(status().is4xxClientError());
    }
}
