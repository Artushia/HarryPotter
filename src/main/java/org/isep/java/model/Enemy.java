package org.isep.java.model;

import lombok.Getter;
import lombok.Setter;

public class Enemy extends Character {

    @Getter
    @Setter
    private final Spell spell;

    @Getter
    @Setter
    String name;

    public Enemy(String name, int hp, Spell spell) {
        super(hp);
        this.name = name;
        this.spell = spell;
    }
}
