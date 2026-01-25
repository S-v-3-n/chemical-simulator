package com.chimie.chemical_simulator.api.dto;

import java.util.Map;

public class ReactionRequest {

    private String equation;
    private Map<String, Integer> reactantAmounts; // H, O, C, etc.

    public ReactionRequest() {
    }

    public ReactionRequest(String equation, Map<String, Integer> reactantAmounts) {
        this.equation = equation;
        this.reactantAmounts = reactantAmounts;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public Map<String, Integer> getReactantAmounts() {
        return reactantAmounts;
    }

    public void setReactantAmounts(Map<String, Integer> reactantAmounts) {
        this.reactantAmounts = reactantAmounts;
    }
}
