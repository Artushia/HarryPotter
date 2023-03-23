package org.isep.java.model;

import lombok.Getter;
import lombok.Setter;

public class Spell {

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
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


