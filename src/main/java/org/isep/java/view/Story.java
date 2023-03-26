package org.isep.java.view;

import org.isep.java.controller.Core;

import static org.isep.java.controller.Core.clearConsole;

public class Story {

    public static void firstAct() {
        Core.printSeperator(60);
        System.out.println("LEVEL I - Dungeon's restroom");
        Core.printSeperator(60);
        System.out.println("In this first level, you will need to use the Wingardium Leviosa spell");
        System.out.println("to raise objects above the troll's head.");
        System.out.println("Good luck !");

    }

    public static void secondAct() {
        Core.printSeperator(60);
        System.out.println("LEVEL II - The Chamber of secrets");
        Core.printSeperator(60);
        System.out.println("You find yourself against the terrible basilic.");
        System.out.println("If you are from Gryffindor house, you may use the legendary Gryffindor sword to take him down.");
        System.out.println("Else, you will need to tear one of his teeth and use it to destroy Tom Jedusor's journal.");
        System.out.println("Good luck ! ");

    }

    public static void winAgainstBoss(String bossName, int lvlNumber) {
        Core.printSeperator(60);
        System.out.println("Congrats ! You killed the " + bossName + " ! ");
        System.out.println("You get to move on to level" + lvlNumber + " ! ");
        Core.printSeperator(60);
        System.out.println("Do you want to get +50 hp (1) or +15 damage (2)");
    }

    public static void gameOver() {
        Core.printSeperator(60);
        System.out.println("Thank you for playing Harry Potter at home RPG");
        System.out.println("By Arthur Terisse");
        Core.printSeperator(60);
    }

    public static void finalWin() {
        clearConsole();
        Core.printSeperator(60);
        System.out.println("Congratulations !");
        System.out.println("You killed the final boss. You graduated from the most prestigious witchcraft college ! ");
        System.out.println("Hope you enjoyed the game realised by @Arthur Terisse");
        Core.printSeperator(60);
    }
}
