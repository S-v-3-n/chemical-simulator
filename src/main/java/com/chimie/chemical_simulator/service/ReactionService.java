package com.chimie.chemical_simulator.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.chimie.chemical_simulator.api.dto.ReactionRequest;
import com.chimie.chemical_simulator.api.dto.SimulationResult;
import com.chimie.chemical_simulator.domain.Molecule;
import com.chimie.chemical_simulator.engine.MoleculeParser;
import com.chimie.chemical_simulator.engine.ParsedReaction;
import com.chimie.chemical_simulator.engine.ReactionParser;

@Service
public class ReactionService {

        private final ReactionParser reactionParser;
        private final MoleculeParser moleculeParser;

        public ReactionService(
                        ReactionParser reactionParser,
                        MoleculeParser moleculeParser) {
                this.reactionParser = reactionParser;
                this.moleculeParser = moleculeParser;
        }

        public SimulationResult simulate(ReactionRequest request) {

                // Parse la réaction
                ParsedReaction parsed = reactionParser.parse(request.getEquation());

                // Parse les molécules de la réaction
                List<Molecule> reactants = parsed.getReactants().stream()
                                .map(moleculeParser::parse)
                                .collect(Collectors.toList());

                List<Molecule> products = parsed.getProducts().stream()
                                .map(moleculeParser::parse)
                                .collect(Collectors.toList());

                // Récupère les quantités d'atomes disponibles
                Map<String, Integer> availableAtoms = request.getReactantAmounts();

                // Calcule combien de molécules de produit peuvent être fabriquées
                Map<String, Integer> productAmounts = new HashMap<>();
                for (int i = 0; i < products.size(); i++) {
                        Molecule product = products.get(i);

                        int maxMolecules = Integer.MAX_VALUE;

                        // Pour chaque atome nécessaire dans le produit
                        for (Map.Entry<String, Integer> entry : product.getAtoms().entrySet()) {
                                String atom = entry.getKey();
                                int required = entry.getValue();

                                int available = availableAtoms.getOrDefault(atom, 0);

                                // Nombre maximal de molécules que l'on peut fabriquer pour cet atome
                                int possible = available / required;

                                if (possible < maxMolecules) {
                                        maxMolecules = possible;
                                }
                        }

                        if (maxMolecules > 0) {
                                productAmounts.put(parsed.getProducts().get(i), maxMolecules);

                                // Décrémente les atomes utilisés
                                for (Map.Entry<String, Integer> entry : product.getAtoms().entrySet()) {
                                        String atom = entry.getKey();
                                        int required = entry.getValue();
                                        availableAtoms.put(atom, availableAtoms.get(atom) - required * maxMolecules);
                                }
                        }
                }

                return new SimulationResult(availableAtoms, productAmounts);
        }
}
