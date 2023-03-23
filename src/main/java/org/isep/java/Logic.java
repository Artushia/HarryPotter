package org.isep.java;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Logic {
    static Scanner sc = new Scanner(System.in);

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
        System.out.println("Your current health: " + wizard.hp);
        while (wizard.hp > 0) {
            wizard.checkHouseForSpecificity();
            while (enemy1.hp > 0) {
                exeLevel(wizard,enemy1);
            }
            Story.winAgainstBoss("Troll", 2);
            winChoice(wizard);
            //org.isep.java.Level 2
            clearConsole();
            Story.secondAct();
            System.out.println("Your current health: " + wizard.hp);
            while (enemy2.hp > 0) {
                exeLevel(wizard, enemy2);
            }

        }
    }

    //General method for the levels
    public static void exeLevel(Wizard wizard, Enemy enemy) throws IOException {
        Spell trollSpell = new Spell("trollSpell", 0.95);
        System.out.println("Your turn to attack ! ");
        System.out.println("Which spell do you want to use ? (Enter the correct number)");

        //Shows the damage you infliged to the Troll for each attack
        int health = enemy.hp;
        Character.attack(wizard.knownSpells.get(listOptions(wizard.knownSpells)), wizard, enemy);
        int damage = health - enemy.hp;
        if (damage == 0) {
            System.out.println("Your spell missed the troll!");
        } else {
            System.out.println("You inflicted " + damage + " of damage towards the Troll");}
        if (enemy.hp > 0) {
            Character.attack(trollSpell, enemy, wizard);
            System.out.println("The troll's health is " + enemy.hp);
            System.out.println("He also attacked you ! Your remaining health is " + wizard.hp);
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
            wizard.hp += 20;
        } else {
            wizard.damage += 10;
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


}
