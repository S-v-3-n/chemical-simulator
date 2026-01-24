package com.chimie.chemical_simulator.engine;

import java.util.Map;

public class BalancedReaction {

    private final Map<String, Integer> reactants;
    private final Map<String, Integer> products;

    public BalancedReaction(
            Map<String, Integer> reactants,
            Map<String, Integer> products) {
        this.reactants = reactants;
        this.products = products;
    }

    public Map<String, Integer> getReactants() {
        return reactants;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }
}
