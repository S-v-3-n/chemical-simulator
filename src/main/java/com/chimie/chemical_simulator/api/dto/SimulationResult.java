package com.chimie.chemical_simulator.api.dto;

import java.util.Map;

public class SimulationResult {

    private String limitingReactant;
    private Map<String, Double> productsProduced;
    private Map<String, Double> reactantsRemaining;

    public SimulationResult(String limitingReactant,
                            Map<String, Double> productsProduced,
                            Map<String, Double> reactantsRemaining) {
        this.limitingReactant = limitingReactant;
        this.productsProduced = productsProduced;
        this.reactantsRemaining = reactantsRemaining;
    }

    public String getLimitingReactant() {
        return limitingReactant;
    }

    public Map<String, Double> getProductsProduced() {
        return productsProduced;
    }

    public Map<String, Double> getReactantsRemaining() {
        return reactantsRemaining;
    }
}
