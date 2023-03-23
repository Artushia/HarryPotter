package org.isep.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.in;

import lombok.Getter;
import lombok.Setter;

public class Wizard extends Character{

    //specifications of the character
    String name;
    private final Pet pet;
    Wand wand;
    House house;
    List<Spell> knownSpells = new ArrayList<>();
    private final List<Potion> potions = new ArrayList<>();

    //Defines the feature of the wizard
    public Wizard( int hp , int damage) {
        super(hp, damage);

        //Set Name
        System.out.println("Hello! What is the name of your wizard? ");
        Scanner sc = new Scanner(in);
        this.name = sc.next();

        //Set org.isep.java.Wand
        int size = 0;
        while ((size > 36) || (size < 24)) {
            System.out.println("Choose a size between 24 and 36 cm for your wand: ");
            size = sc.nextInt();}
        System.out.println("Enter the number corresponding to the desired core: ");
        for (int i=0; i<Core.values().length; i++) {
            System.out.println(i + " -> " + Core.values()[i]);}
        //Checks if value entered by user is correct
        int index = Core.values().length;
        while (index > Core.values().length - 1) {
            index = sc.nextInt();}
        Core core = Core.values()[index];
        this.wand = new Wand(core,size);

        //Set org.isep.java.House
        SortingHat sortingHat = new SortingHat();
        this.house = new House("SLYTHERIN");
        //this.house = sortingHat.pickHouse();

        //Set org.isep.java.Pet
        System.out.println("Enter the number corresponding to the desired pet: ");
        for (int i=0; i<Pet.values().length; i++) {
            System.out.println(i + " -> " + Pet.values()[i]);}
        //Checks if value entered by user is correct
        int chooseValue = Pet.values().length;
        while (chooseValue > Pet.values().length - 1) {
            chooseValue = sc.nextInt();}
        this.pet = Pet.values()[chooseValue];

        //adds Wanguardium Leviosa by default at beginning of game
        Spell Leviosa = new Spell("Wanguardium Leviosa", 0.85);
        knownSpells.add(Leviosa);


        //Recap of wizard's characteristic
        System.out.println("Your wizard : name = " + this.name + ", pet = " + this.pet + ", wand = " + wand + ", house = " + house);
    }

    @Override
    public void setHp(int hp) {
        super.setHp(hp);
    }

    @Override
    public void setDamage(int damage) {
        super.setDamage(damage);
    }

    //checks for house type and adds specificity
    public void checkHouseForSpecificity() {
        //Specificity for RAVENCLAW house - are more precise
        if (this.house.toString().equals("RAVENCLAW")) {
            for (int i=0; i < this.knownSpells.size(); i++) {
                double spellSuccess = this.knownSpells.get(i).percentSuccess;
                if (spellSuccess < 0.95) {spellSuccess += 0.05;}
            }

            //Specificity for SLYTHERIN house - do higher damage
        } else if (this.house.toString().equals("SLYTHERIN")) {
            this.damage += 5;}
    }

}



