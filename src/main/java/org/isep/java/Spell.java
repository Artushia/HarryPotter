package org.isep.java;

import lombok.Getter;
import lombok.Setter;

public class Spell {

    String name;
    double percentSuccess;

    public Spell(String name, double percentSuccess) {
        this.name = name;
        this.percentSuccess = percentSuccess;
    }

    @Override
    public String toString() {
        return name;
    }
}


