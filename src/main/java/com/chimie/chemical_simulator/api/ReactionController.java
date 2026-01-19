package com.chimie.chemical_simulator.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chimie.chemical_simulator.api.dto.ReactionRequest;
import com.chimie.chemical_simulator.api.dto.SimulationResult;
import com.chimie.chemical_simulator.service.ReactionService;

@RestController
@RequestMapping("/api/reactions")
public class ReactionController {

    private final ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    @PostMapping("/simulate")
    public SimulationResult simulate(@RequestBody ReactionRequest request) {
        return reactionService.simulate(request);
    }
}
