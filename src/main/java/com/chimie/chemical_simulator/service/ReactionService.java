package com.chimie.chemical_simulator.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.chimie.chemical_simulator.api.dto.ReactionRequest;
import com.chimie.chemical_simulator.api.dto.SimulationResult;

@Service
public class ReactionService {

    public SimulationResult simulate(ReactionRequest request) {

        // ⚠️ MOCK TEMPORAIRE
        // remplacé plus tard par le moteur chimique

        return new SimulationResult(
                "O2",
                Map.of("H2O", 4.0),
                Map.of("H2", 1.0)
        );
    }
}
