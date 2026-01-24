package com.chimie.chemical_simulator.engine;

import java.util.List;

public class ParsedReaction {

    private final List<String> reactants;
    private final List<String> products;

    public ParsedReaction(List<String> reactants, List<String> products) {
        this.reactants = reactants;
        this.products = products;
    }

    public List<String> getReactants() {
        return reactants;
    }

    public List<String> getProducts() {
        return products;
    }
}
