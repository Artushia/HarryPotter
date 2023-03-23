package org.isep.java.model;

import lombok.Getter;
import lombok.Setter;

public abstract class Character {

    @Getter
    @Setter
    private int hp;
    @Getter
    @Setter
    private int damage;

    public Character(int hp, int damage) {
        this.hp = hp;
        this.damage = damage;
    }

}

