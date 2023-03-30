package org.isep.java.model;

public class ForbiddenSpell extends AbstractSpell {

    public ForbiddenSpell(String name, double percentSuccess, int damage ) {
        this.name = name;
        this.percentSuccess = percentSuccess;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
