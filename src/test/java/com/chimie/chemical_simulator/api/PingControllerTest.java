package com.chimie.chemical_simulator.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PingController.class) // Remplace par le nom de ton controller contenant /ping
public class PingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void pingShouldReturnOkMessage() throws Exception {
        mockMvc.perform(get("/ping"))
                .andExpect(status().isOk())
                .andExpect(content().string("Spring Boot OK 🚀"));
    }
}
