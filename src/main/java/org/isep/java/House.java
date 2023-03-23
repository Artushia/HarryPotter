package org.isep.java;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class House {

    String name;

    public House(String name) {
        this.name = name;
    }

    @Override
    public String toString() {return name;}
}
