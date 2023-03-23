package org.isep.java.model;

import lombok.Getter;
import lombok.Setter;

public class Wand {

    @Getter
    @Setter
    private Core core;

    @Getter
    @Setter
    private int size;

    //Constructor
    public Wand(Core core, int size) {
        this.core = core;
        this.size = size;
    }

    @Override
    public String toString() {
        return core + " and size " + size + " cm";
    }
}
