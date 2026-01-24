package com.chimie.chemical_simulator.engine;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ReactionParser {

    public ParsedReaction parse(String equation) {

        if (!equation.contains("->")) {
            throw new IllegalArgumentException("Invalid equation format");
        }

        String[] sides = equation.split("->");

        List<String> reactants = List.of(sides[0].trim().split("\\+"))
                .stream()
                .map(String::trim)
                .toList();

        List<String> products = List.of(sides[1].trim().split("\\+"))
                .stream()
                .map(String::trim)
                .toList();

        return new ParsedReaction(reactants, products);
    }
}
