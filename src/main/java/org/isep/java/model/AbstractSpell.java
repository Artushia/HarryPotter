package org.isep.java.model;

import lombok.Getter;
import lombok.Setter;

public abstract class  AbstractSpell {

    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    double percentSuccess;

    @Getter
    @Setter
    int damage;

}
