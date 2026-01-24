package com.chimie.chemical_simulator.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.chimie.chemical_simulator.domain.Molecule;

@Component
public class MoleculeParser {

    private static final Pattern ATOM_PATTERN =
            Pattern.compile("([A-Z][a-z]?)(\\d*)");

    public Molecule parse(String formula) {

        Map<String, Integer> atoms = new HashMap<>();
        Matcher matcher = ATOM_PATTERN.matcher(formula);

        while (matcher.find()) {
            String element = matcher.group(1);
            String countStr = matcher.group(2);

            int count = countStr.isEmpty() ? 1 : Integer.parseInt(countStr);

            atoms.merge(element, count, Integer::sum);
        }

        if (atoms.isEmpty()) {
            throw new IllegalArgumentException("Invalid molecule: " + formula);
        }

        return new Molecule(atoms);
    }
}
