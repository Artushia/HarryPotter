package org.isep.java.controller;

import org.isep.java.model.*;
import org.isep.java.model.Character;
import org.isep.java.view.Story;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Core {

    private static final Scanner sc = new Scanner(System.in);
    private static final Random rand = new Random();

    public void main(String[] args) throws IOException, InterruptedException {
        exeGame();
    }

    public void exeGame() throws IOException, InterruptedException {

        //Game intro
        Story.welcomeUser();

        //Instantiate the wizard
        Wizard wizard = new Wizard(100);

        //Instantiate enemy attacks
        Spell trollSpell = new Spell("trollSpell", 0.9, 15);
        Spell basilicSpell = new Spell("basilicSpell", 0.9, 15);
        Spell detraqueursSpell = new Spell("detraqueursSpell", 0.9, 20);
        Spell voldemortSpell = new Spell("voldemortSpell", 0.9, 22);
        Spell doloresSpell = new Spell("doloresSpell", 0.9, 25);
        Spell mangemortsSpell = new Spell("mangemortsSpell", 0.9, 27);
        Spell bellatrixSpell = new Spell("Avada Kedavra", 0.2, 100);

        //Instantiate enemy's
        Enemy enemy1 = new Enemy("Troll", 100, trollSpell);
        Enemy enemy2 = new Enemy("Basilic", 100, basilicSpell);
        Enemy enemy3 = new Enemy("Detraqueurs", 100,detraqueursSpell);
        Enemy enemy4 = new Enemy("Voldemort&Peter", 100,voldemortSpell);
        Enemy enemy5 = new Enemy("Dolores", 100,doloresSpell);
        Enemy enemy6 = new Enemy("Mangemorts", 100,mangemortsSpell);
        Enemy enemy7 = new Enemy("Voldemort&Bellatrix", 100,bellatrixSpell);

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
    public boolean isAlive(Character character) {
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
            for (int i=0; i < wizard.getKnownSpells().size(); i++) {
                Spell spell = wizard.getKnownSpells().get(i);
                int spellDamage = spell.getDamage();
                spell.setDamage(spellDamage + 5);
                }
        }
    }

    //General method for the levels
    public static void attackLogic(Wizard wizard, Enemy enemy) throws IOException {
        System.out.println("Your turn to play !");
        int cond;
        int potionStock = wizard.getPotions().size();
        do { System.out.printf("Do you wish to attack or use a potion ? 1 - attack | 2 - Use a potion (%d left)%n", potionStock);
            cond = sc.nextInt();
        } while (cond != 1 && cond != 2);
        //checks if there are potions left
        if (cond == 2 && potionStock == 0) {
            System.out.println("You do not have any potions left. You must attack the enemy.");
            cond = 1;
        }

        if (cond == 1) {
            System.out.println("Which spell do you want to use ? (Enter the correct number)");
            //Shows the damage you infliged to the Troll for each attack
            int enemyHealth = enemy.getHp();
            attack(wizard.getKnownSpells().get(listOptions(wizard.getKnownSpells())), enemy);
            int wizardDamage = enemyHealth - enemy.getHp();
            if (wizardDamage == 0) {
                System.out.printf("Your spell missed %s !%n", enemy.getName());
            } else {
                System.out.printf("You inflicted %d of damage towards the %s. [His remaining health is %d]%n", wizardDamage, enemy.getName(), enemy.getHp());
            }
            if (enemy.getHp() > 0) {
                int wizardHealth = wizard.getHp();
                attack(enemy.getSpell(), wizard);
                int enemyDamage = wizardHealth - wizard.getHp();
                if (enemyDamage == 0) {
                    System.out.println("He attacked but missed you");
                } else {
                    System.out.printf("%s inflicted %d damage on you. [Your remaining health is %d]%n",enemy.getName(), enemyDamage, wizard.getHp());
                }
                enterToContinue();
            }
        } else {
            System.out.println("You chose to use a potion...and gain 25 lives");
            wizard.getPotions().remove(0);
            wizard.setHp(Math.min(wizard.getHp() + 25, 100));
        }
    }

    public void executeLevel1(Wizard wizard, Enemy enemy1) throws IOException, InterruptedException {
        Story.firstAct();
        while (isAlive(wizard) && isAlive(enemy1)) {
            attackLogic(wizard,enemy1);
        }
        if (isAlive(wizard)) {
            Story.winAgainstBoss(enemy1.getName(), 2);
            winChoice(wizard);
        } else {Story.youDied();}
    }

    public void executeLevel2(Wizard wizard, Enemy enemy2) throws IOException, InterruptedException {
        clearConsole();
        if (wizard.getHouse().toString().equals("GRYFFINDOR")) {
            Spell sword = new Spell("Legendary sword", 0.99, 50);
            wizard.getKnownSpells().add(sword);
        } else {
            Spell accio = new Spell("Accio", 0.95, 10 );
            wizard.getKnownSpells().add(accio);
        }
        Story.secondAct();
        while (isAlive(wizard) && isAlive(enemy2)) {
            attackLogic(wizard,enemy2);
        }
        if (isAlive(wizard)) {
            Story.winAgainstBoss(enemy2.getName(), 3);
            winChoice(wizard);
        } else {Story.youDied();}
    }

    public void executeLevel3(Wizard wizard, Enemy enemy3) throws IOException, InterruptedException {
        clearConsole();
        Spell expectro = new Spell("Expectro Patronum", 0.87, 30);
        wizard.getKnownSpells().add(expectro);
        Story.thirdAct();
        while (isAlive(wizard) && isAlive(enemy3)) {
            attackLogic(wizard,enemy3);
        }
        if (isAlive(wizard)) {
            Story.winAgainstBoss(enemy3.getName(), 4);
            winChoice(wizard);
        } else {Story.youDied();}
    }

    public void executeLevel4(Wizard wizard, Enemy enemy4) throws IOException, InterruptedException {
        clearConsole();
        Story.fourthAct();
        while (isAlive(wizard) && isAlive(enemy4)) {
            attackLogic(wizard,enemy4);
        }
        if (isAlive(wizard)) {
            Story.winAgainstBoss(enemy4.getName(), 5);
            winChoice(wizard);
        } else {Story.youDied();}
    }

    public void executeLevel5(Wizard wizard, Enemy enemy5) throws IOException, InterruptedException {
        Random rand = new Random();
        clearConsole();
        Story.fifthAct();
        while (isAlive(wizard) && isAlive(enemy5)) {
            attackLogic(wizard,enemy5);
            if (rand.nextInt(10) == 0) {
                enemy5.setHp(0);
            }
        }
        if (isAlive(wizard)) {
            Story.winAgainstBoss(enemy5.getName(), 6);
            winChoice(wizard);
        } else {Story.youDied();}
    }

    public void executeLevel6(Wizard wizard, Enemy enemy6) throws IOException, InterruptedException {
        clearConsole();
        Story.sixthAct();
        ForbiddenSpell sectumsempra = new ForbiddenSpell("Sectumsempra", 0.99, 100);
        System.out.println("Do you want to join Mangemorts' rank and use a forbidden spell to kill Mangemorts ? ");
        System.out.println("0 -> YES");
        System.out.println("1 -> NO");
        if ((wizard.getHouse().toString().equals("SLYTHERIN")) && sc.nextInt() == 1) {
            System.out.println("You used the forbidden spell Sectumsempra !");
            attack(sectumsempra, enemy6);
        } else {
            Story.sixthAct();
            while (isAlive(wizard) && isAlive(enemy6)) {
                attackLogic(wizard, enemy6);
            }

        }
        if (isAlive(wizard)) {
            Story.winAgainstBoss(enemy6.getName(), 7);
            winChoice(wizard);
        } else {Story.youDied();}
    }

    public void executeLevel7(Wizard wizard, Enemy enemy7) throws IOException, InterruptedException {
        clearConsole();
        Story.seventhAct();
        while (isAlive(wizard) && isAlive(enemy7)) {
            attackLogic(wizard,enemy7);
        }
        if (isAlive(wizard)) {
            Story.finalWin();
            winChoice(wizard);
        } else {Story.youDied();}
    }


    //Method in case player wins level
    public void winChoice(Wizard wizard) {
        int choice = 0;
        while ((choice != 1) && (choice != 2)) {
            System.out.println("Enter either 1 or 2: ");
            choice = sc.nextInt();}
        if (choice == 1) {
            wizard.setHp(Math.min(wizard.getHp() + 50, 100));
        } else {
            for (int i=0; i < wizard.getKnownSpells().size(); i++) {
                Spell spell = wizard.getKnownSpells().get(i);
                int spellDamage = spell.getDamage();
                spell.setDamage(spellDamage + 15);
                }        }
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

    public static void attack(AbstractSpell spellName, Character defender) {

        int bonus = 0;
        //Specificity of GRYFFINDOR house -> higher resistance from damage
        if (defender instanceof Wizard) {
            if (((Wizard) defender).getHouse().toString().equals("GRYFFINDOR")) {
                bonus = 5;
            }
        }
        if (getRandomZeroOne(spellName.getPercentSuccess()) == 1) {
            defender.setHp((defender.getHp() - spellName.getDamage() + bonus));
        }
    }

    //Method that return 0 if random float is less than 1 - percent success or 1 if random float is higher than 1 - percent success
    public static int getRandomZeroOne(double percentSuccess) {
        return (rand.nextDouble() >= (1 - percentSuccess)) ? 1 : 0;
    }


}
