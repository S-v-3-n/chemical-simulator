package com.chimie.chemical_simulator.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "Spring Boot OK 🚀";
    }
}
