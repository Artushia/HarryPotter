import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Logic {

    public static void main(String[] args) throws IOException {
        exeGame();
    }

    public static void exeGame() throws IOException {
        //Instantiate the wizard's and enemy's classes
        Wizard wizard = new Wizard();
        Enemy enemy1 = new Enemy("Troll", 100);

        //Level 1
        clearConsole();
        Story.firstAct();
        while (wizard.hp > 0) {
            while (enemy1.hp > 0) {
                exeLevel(wizard,enemy1, 20);
            }
            Story.winAgainstBoss("Troll", 2);
            break;
        }
    }

    //General method for the levels
    public static void exeLevel(Wizard wizard, Enemy enemy, int enemyDamage) throws IOException {
        Spell trollSpell = new Spell("trollSpell", 100, enemyDamage);
        System.out.println("Your turn to attack ! ");
        System.out.println("Which spell do you want to use ? (Enter the correct number)");
        wizard.attack(wizard.knownSpells.get(listOptions(wizard.knownSpells)), enemy);
        enemy.attack(trollSpell, wizard);
        System.out.println("The troll's health is " + enemy.hp);
        System.out.println("He also attacked you ! Your remaining health is " + wizard.hp);
        enterToContinue();
    }

    //Method to list different options and verify correct input
    public static int listOptions(List list) {
        Scanner sc = new Scanner(System.in);
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
