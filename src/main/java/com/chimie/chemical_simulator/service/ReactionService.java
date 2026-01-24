package com.chimie.chemical_simulator.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.chimie.chemical_simulator.api.dto.ReactionRequest;
import com.chimie.chemical_simulator.api.dto.SimulationResult;
import com.chimie.chemical_simulator.engine.BalancedReaction;
import com.chimie.chemical_simulator.engine.MoleculeParser;
import com.chimie.chemical_simulator.engine.ParsedReaction;
import com.chimie.chemical_simulator.engine.ReactionBalancer;
import com.chimie.chemical_simulator.engine.ReactionParser;


@Service
public class ReactionService {

    private final ReactionParser reactionParser;
    private final MoleculeParser moleculeParser;
    private final ReactionBalancer reactionBalancer;

    public ReactionService(
            ReactionParser reactionParser,
            MoleculeParser moleculeParser,
            ReactionBalancer reactionBalancer) {
        this.reactionParser = reactionParser;
        this.moleculeParser = moleculeParser;
        this.reactionBalancer = reactionBalancer;
    }

    public SimulationResult simulate(ReactionRequest request) {

        ParsedReaction pr =
                reactionParser.parse(request.getEquation());

        String r1 = pr.getReactants().get(0);
        String r2 = pr.getReactants().get(1);
        String p = pr.getProducts().get(0);

        BalancedReaction balanced =
                reactionBalancer.balance(
                        r1, moleculeParser.parse(r1),
                        r2, moleculeParser.parse(r2),
                        p, moleculeParser.parse(p)
                );

        System.out.println("Balanced: " + balanced.getReactants()
                + " -> " + balanced.getProducts());

        return new SimulationResult(
                "O2",
                Map.of("H2O", 4.0),
                Map.of("H2", 1.0)
        );
    }
}
