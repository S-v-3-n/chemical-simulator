package com.chimie.chemical_simulator.api.dto;

import java.util.Map;

public class ReactionRequest {

    private String equation;
    private Map<String, Double> reactantAmounts;

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public Map<String, Double> getReactantAmounts() {
        return reactantAmounts;
    }

    public void setReactantAmounts(Map<String, Double> reactantAmounts) {
        this.reactantAmounts = reactantAmounts;
    }
}
