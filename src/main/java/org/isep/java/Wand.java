package org.isep.java;

public class Wand {

    private final Core core;
    private final int size;

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
