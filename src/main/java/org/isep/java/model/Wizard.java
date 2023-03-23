package org.isep.java.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import org.isep.java.controller.SortingHat;
import org.isep.java.view.WizardView;

public class Wizard extends Character {

    //specifications of the character
    @Getter
    @Setter
    String name;

    @Getter
    @Setter
    private final Pet pet;

    @Getter
    @Setter
    Wand wand;

    @Getter
    @Setter
    House house;

    @Getter
    @Setter
    List<Spell> knownSpells = new ArrayList<>();

    @Getter
    @Setter
    private final List<Potion> potions = new ArrayList<>();

    //Defines the feature of the wizard
    public Wizard( int hp , int damage) {
        super(hp, damage);

        //Set Name
        this.name = WizardView.choseName();

        //Set org.isep.java.model.Wand
        int size = WizardView.choseSize();
        Core core = WizardView.choseCore();
        this.wand = new Wand(core,size);

        //Set org.isep.java.model.House
        SortingHat sortingHat = new SortingHat();
        this.house = new House("RAVENCLAW");
        //this.house = sortingHat.pickHouse();

        //Set org.isep.java.model.Pet
        this.pet = WizardView.choosePet();

        //adds Wanguardium Leviosa by default at beginning of game
        Spell Leviosa = new Spell("Wanguardium Leviosa", 0.85);
        knownSpells.add(Leviosa);


        //Recap of wizard's characteristic
        System.out.println("Your wizard : name = " + this.name + ", pet = " + this.pet + ", wand = " + wand + ", house = " + house);
    }



}



