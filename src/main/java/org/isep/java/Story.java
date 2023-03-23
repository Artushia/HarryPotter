package org.isep.java;

public class Story {

    public static void firstAct() {
        Logic.printSeperator(60);
        System.out.println("LEVEL I - Dungeon's restroom");
        Logic.printSeperator(60);
        System.out.println("In this first level, you will need to use the Wingardium Leviosa spell");
        System.out.println("to raise objects above the troll's head.");
        System.out.println("Good luck !");

    }

    public static void secondAct() {
        Logic.printSeperator(60);
        System.out.println("LEVEL II - The Chamber of secrets");
        Logic.printSeperator(60);
        System.out.println("You find yourself against the terrible basilic.");
        System.out.println("If you are from Gryffindor house, you may use the legendary Gryffindor sword to take him down.");
        System.out.println("Else, you will need to tear one of his teeth and use it to destroy Tom Jedusor's journal.");
        System.out.println("Good luck ! ");

    }

    public static void winAgainstBoss(String bossName, int lvlNumber) {
        Logic.printSeperator(60);
        System.out.println("Congrats ! You killed the " + bossName + " ! ");
        System.out.println("You get to move on to level" + lvlNumber + " ! ");
        Logic.printSeperator(60);
        System.out.println("Do you want to get +20 hp (1) or +10 damage (2)");
    }
}
