package com.chimie.chemical_simulator.engine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.chimie.chemical_simulator.domain.Molecule;

@Component
public class ReactionBalancer {

    public BalancedReaction balance(
        String r1, Molecule m1,
        String r2, Molecule m2,
        String p, Molecule mp) {

        // Créer un set mutable des éléments
        Set<String> elements = new HashSet<>(m1.getAtoms().keySet());
        elements.addAll(m2.getAtoms().keySet());

        int a = 1, b = 1, c = 1;

        outer:
        for (a = 1; a <= 10; a++) {
            for (b = 1; b <= 10; b++) {
                for (c = 1; c <= 10; c++) {

                    boolean ok = true;

                    for (String e : elements) {
                        int left = a * m1.getAtoms().getOrDefault(e, 0)
                                + b * m2.getAtoms().getOrDefault(e, 0);
                        int right = c * mp.getAtoms().getOrDefault(e, 0);

                        if (left != right) {
                            ok = false;
                            break;
                        }
                    }

                    if (ok) break outer;
                }
            }
        }

        Map<String, Integer> reactants = new HashMap<>();
        reactants.put(r1, a);
        reactants.put(r2, b);

        Map<String, Integer> products = new HashMap<>();
        products.put(p, c);

        return new BalancedReaction(reactants, products);
    }
}
