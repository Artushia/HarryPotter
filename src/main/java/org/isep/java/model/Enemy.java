package org.isep.java.model;

import lombok.Getter;
import lombok.Setter;
import org.isep.java.model.Character;

public class Enemy extends Character {

    @Getter
    @Setter
    String name;

    public Enemy(String name, int hp, int damage) {
        super(hp, damage);
        this.name = name;
    }
}
