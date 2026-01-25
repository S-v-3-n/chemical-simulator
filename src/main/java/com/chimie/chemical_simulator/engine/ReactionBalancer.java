package com.chimie.chemical_simulator.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.chimie.chemical_simulator.domain.Molecule;

@Component
public class ReactionBalancer {

    /**
     * Produit autant de molécules complètes que possible en fonction
     * des atomes disponibles, pour n'importe quels éléments chimiques.
     */
    public Map<String, Integer> produceFromAtoms(Map<String, Integer> availableAtoms, List<Molecule> products) {
        Map<String, Integer> result = new HashMap<>();

        for (Molecule p : products) {
            int maxMolecules = Integer.MAX_VALUE;

            for (Map.Entry<String, Integer> entry : p.getAtoms().entrySet()) {
                String element = entry.getKey();
                int countNeeded = entry.getValue();
                int available = availableAtoms.getOrDefault(element, 0);

                // combien de molécules complètes peut-on faire avec cet élément
                maxMolecules = Math.min(maxMolecules, available / countNeeded);
            }

            if (maxMolecules > 0) {
                result.put(p.getFormula(), maxMolecules);

                // retirer les atomes utilisés
                for (Map.Entry<String, Integer> entry : p.getAtoms().entrySet()) {
                    String element = entry.getKey();
                    int used = entry.getValue() * maxMolecules;
                    availableAtoms.put(element, availableAtoms.get(element) - used);
                }
            }
        }

        return result;
    }
}
