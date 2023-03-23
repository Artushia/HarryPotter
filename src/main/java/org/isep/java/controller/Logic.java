package org.isep.java.controller;

import org.isep.java.model.Character;
import org.isep.java.model.Enemy;
import org.isep.java.model.Spell;
import org.isep.java.model.Wizard;
import org.isep.java.view.Story;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Logic {

    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();


    public static void main(String[] args) throws IOException {
        exeGame();
    }

    public static void exeGame() throws IOException {
        //Instantiate the wizard's and enemy's classes
        Wizard wizard = new Wizard(100,20);
        enterToContinue();
        Enemy enemy1 = new Enemy("Troll", 100, 20);
        Enemy enemy2 = new Enemy("Basilic", 100, 25);

        //org.isep.java.Level 1
        clearConsole();
        Story.firstAct();
        System.out.println("Your current health: " + wizard.getHp());
        while (wizard.getHp() > 0) {
            checkHouseForSpecificity(wizard);
            System.out.println("Percentage of success is " + wizard.getKnownSpells().get(0).getPercentSuccess());
            while (enemy1.getHp() > 0) {
                exeLevel(wizard,enemy1);
            }
            Story.winAgainstBoss("Troll", 2);
            winChoice(wizard);
            //org.isep.java.Level 2
            clearConsole();
            Story.secondAct();
            System.out.println("Your current health: " + wizard.getHp());
            while (enemy2.getHp() > 0) {
                exeLevel(wizard, enemy2);
            }

        }
    }
    //checks for house type and adds specificity
    public static void checkHouseForSpecificity(Wizard wizard) {
        //Specificity for RAVENCLAW house - are more precise
        if (wizard.getHouse().toString().equals("RAVENCLAW")) {
            for (int i=0; i < wizard.getKnownSpells().size(); i++) {
                Spell spell = wizard.getKnownSpells().get(i);
                double spellSuccess = spell.getPercentSuccess();
                if (spellSuccess < 0.95) {
                    spellSuccess += 0.05;
                    spell.setPercentSuccess(spellSuccess);
                }
            }

            //Specificity for SLYTHERIN house - do higher damage
        } else if (wizard.getHouse().toString().equals("SLYTHERIN")) {
            wizard.setDamage(wizard.getDamage() + 5);}
    }

    //General method for the levels
    public static void exeLevel(Wizard wizard, Enemy enemy) throws IOException {
        Spell trollSpell = new Spell("trollSpell", 0.95);
        System.out.println("Your turn to attack ! ");
        System.out.println("Which spell do you want to use ? (Enter the correct number)");

        //Shows the damage you infliged to the Troll for each attack
        int health = enemy.getHp();
        attack(wizard.getKnownSpells().get(listOptions(wizard.getKnownSpells())), wizard, enemy);
        int damage = health - enemy.getHp();
        if (damage == 0) {
            System.out.println("Your spell missed the troll!");
        } else {
            System.out.println("You inflicted " + damage + " of damage towards the Troll");}
        if (enemy.getHp() > 0) {
            attack(trollSpell, enemy, wizard);
            System.out.println("The troll's health is " + enemy.getHp());
            System.out.println("He also attacked you ! Your remaining health is " + wizard.getHp());
            enterToContinue();
        }
    }

    //Method in case player wins level
    public static void winChoice(Wizard wizard) {
        int choice = 0;
        while ((choice != 1) && (choice != 2)) {
            System.out.println("Enter either 1 or 2: ");
            choice = sc.nextInt();}
        if (choice == 1) {
            wizard.setHp(wizard.getHp() - 20);
        } else {
            wizard.setDamage(wizard.getDamage() + 10);
        }
        printSeperator(60);
    }

    //Method to list different options and verify correct input
    public static int listOptions(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + " -> " + list.get(i));
        }
        int chooseValue = list.size();
        while (chooseValue > list.size() - 1) {
            chooseValue = sc.nextInt();
        }
        return chooseValue;
    }

    //Method to stop the game until users presses a key
    public static void enterToContinue() throws IOException {
        System.out.println("Press ENTER key to continue...");
        System.in.read();
    }

    //Method to print a seperator with length n from @CodeStudent on Youtube
    public static void printSeperator(int n) {
        for (int i =0; i < n ; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    //Method to simulate clearing out the console from @CodeStudent on Youtube
    public static void clearConsole() {
        for (int i = 0; i < 100; i ++) {
            System.out.println();
        }
    }

    public static void attack(Spell spellName, Character attacker, Character defender) {

        int bonus = 0;
        //Specificity of GRYFFINDOR house -> higher resistance from damage
        if (defender instanceof Wizard) {
            if (((Wizard) defender).getHouse().toString().equals("GRYFFINDOR")) {
                bonus = 5;
            }
        }

        defender.setHp(defender.getHp() - ((attacker.getDamage() * getRandomZeroOne(spellName.getPercentSuccess())) - bonus));
    }

    //Method that return 0 if random float is less than 1 - percent success or 1 if random float is higher than 1 - percent success
    public static int getRandomZeroOne(double percentSuccess) {
        return (rand.nextDouble() >= (1 - percentSuccess)) ? 1 : 0;
    }


}
