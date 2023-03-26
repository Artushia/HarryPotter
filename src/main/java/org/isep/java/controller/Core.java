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


public class Core {

    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();

    public static void main(String[] args) throws IOException {
        exeGame();
    }

    public static void exeGame() throws IOException {

        //Instantiate the wizard
        Wizard wizard = new Wizard(100,20);

        //Instantiate enemy's
        Enemy enemy1 = new Enemy("Troll", 100, 20);
        Enemy enemy2 = new Enemy("Basilic", 100, 22);
        Enemy enemy3 = new Enemy("Detraqueurs", 100, 24);
        Enemy enemy4 = new Enemy("Voldemort&Peter", 100,26 );
        Enemy enemy5 = new Enemy("Dolores", 100, 28);
        Enemy enemy6 = new Enemy("Mangemorts", 100, 30);
        Enemy enemy7 = new Enemy("Voldemort&Bellatrix", 100, 35);

        //Execution of the levels
        clearConsole();
        checkHouseForSpecificity(wizard);
        executeLevel1(wizard, enemy1);
        executeLevel2(wizard, enemy2);
        executeLevel3(wizard, enemy3);
        executeLevel4(wizard, enemy4);
        executeLevel5(wizard, enemy5);
        executeLevel6(wizard, enemy6);
        executeLevel7(wizard, enemy7);
        Story.gameOver();
    }

    //Checks if wizard is alive
    public static boolean isAlive(Character character) {
        return character.getHp() > 0;
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
    public static void attackLogic(Wizard wizard, Enemy enemy) throws IOException {
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
            enterToContinue();
        if (enemy.getHp() > 0) {
            System.out.println("The troll's health before he attack is " + enemy.getHp());
            attack(trollSpell, enemy, wizard);
            System.out.println("The troll's health is " + enemy.getHp());
            System.out.println("He also attacked you ! Your remaining health is " + wizard.getHp());
            enterToContinue();
        }
    }

    public static void executeLevel1(Wizard wizard, Enemy enemy1) throws IOException {
        Story.firstAct();
        while (isAlive(wizard) && isAlive(enemy1)) {
            attackLogic(wizard,enemy1);
        }
        Story.winAgainstBoss(enemy1.getName(), 2);
        winChoice(wizard);
    }

    public static void executeLevel2(Wizard wizard, Enemy enemy2) throws IOException {
        clearConsole();
        Story.secondAct();
        while (isAlive(wizard) && isAlive(enemy2)) {
            attackLogic(wizard,enemy2);
        }
        Story.winAgainstBoss(enemy2.getName(), 3);
        winChoice(wizard);
    }

    public static void executeLevel3(Wizard wizard, Enemy enemy3) throws IOException {
        clearConsole();
        Story.firstAct();
        while (isAlive(wizard) && isAlive(enemy3)) {
            attackLogic(wizard,enemy3);
        }
        Story.winAgainstBoss(enemy3.getName(), 4);
        winChoice(wizard);
    }

    public static void executeLevel4(Wizard wizard, Enemy enemy4) throws IOException {
        clearConsole();
        Story.firstAct();
        while (isAlive(wizard) && isAlive(enemy4)) {
            attackLogic(wizard,enemy4);
        }
        Story.winAgainstBoss(enemy4.getName(), 5);
        winChoice(wizard);
    }

    public static void executeLevel5(Wizard wizard, Enemy enemy5) throws IOException {
        clearConsole();
        Story.firstAct();
        while (isAlive(wizard) && isAlive(enemy5)) {
            attackLogic(wizard,enemy5);
        }
        Story.winAgainstBoss(enemy5.getName(), 6);
        winChoice(wizard);
    }

    public static void executeLevel6(Wizard wizard, Enemy enemy6) throws IOException {
        clearConsole();
        Story.firstAct();
        while (isAlive(wizard) && isAlive(enemy6)) {
            attackLogic(wizard,enemy6);
        }
        Story.winAgainstBoss(enemy6.getName(), 7);
        winChoice(wizard);
    }

    public static void executeLevel7(Wizard wizard, Enemy enemy7) throws IOException {
        clearConsole();
        Story.firstAct();
        while (isAlive(wizard) && isAlive(enemy7)) {
            attackLogic(wizard,enemy7);
        }
        Story.finalWin();
        winChoice(wizard);
    }


    //Method in case player wins level
    public static void winChoice(Wizard wizard) {
        int choice = 0;
        while ((choice != 1) && (choice != 2)) {
            System.out.println("Enter either 1 or 2: ");
            choice = sc.nextInt();}
        if (choice == 1) {
            wizard.setHp(wizard.getHp() + 50);
        } else {
            wizard.setDamage(wizard.getDamage() + 15);
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
