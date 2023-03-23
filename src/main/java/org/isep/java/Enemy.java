package org.isep.java;

public class Enemy extends Character{

    String name;

    public Enemy(String name, int hp, int damage) {
        super(hp, damage);
        this.name = name;
    }
}
