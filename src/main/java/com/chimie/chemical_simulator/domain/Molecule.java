package com.chimie.chemical_simulator.domain;

import java.util.Map;

public class Molecule {

    private final Map<String, Integer> atoms;

    public Molecule(Map<String, Integer> atoms) {
        this.atoms = atoms;
    }

    public Map<String, Integer> getAtoms() {
        return atoms;
    }

    @Override
    public String toString() {
        return atoms.toString();
    }
}
