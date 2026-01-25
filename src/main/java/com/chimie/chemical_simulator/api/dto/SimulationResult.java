package com.chimie.chemical_simulator.api.dto;

import java.util.Map;

public record SimulationResult(
        Map<String, Integer> reactants,
        Map<String, Integer> products
) {}
