package org.isep.java.model;

import lombok.Getter;
import lombok.Setter;

public class Enemy extends Character {

    @Getter
    @Setter
    String name;

    public Enemy(String name, int hp, int damage) {
        super(hp, damage);
        this.name = name;
    }
}
