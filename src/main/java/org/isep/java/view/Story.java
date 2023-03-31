package org.isep.java.view;

import org.isep.java.controller.Core;

import static org.isep.java.controller.Core.clearConsole;

public class Story {

    public static void welcomeUser() {

        Core.printSeperator(60);
        System.out.println("Welcome to Harry Potter at Home !");
        System.out.println("In this Role Playing Game, you will become a wizard and combat many ennemies...");
        System.out.println("While you are alive, you continue to fight new ennemies ! There are seven levels so don't die !");
        Core.printSeperator(60);
    }

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

    public static void thirdAct() {
        Core.printSeperator(60);
        System.out.println("LEVEL III - The Prisonner of Azkaban");
        Core.printSeperator(60);
        System.out.println("The Detraqueurs are somewhere free, in the countryside, the streets.");
        System.out.println("Thankfully, you heard of a spell that repels them...Expect....Expecta....Oh yes ! ");
        System.out.println("It is Expectro Patronum. Now that you recall its name, use it to beat the Detraqueurs.");
        System.out.println("Good luck ! ");

    }

    public static void fourthAct() {
        Core.printSeperator(60);
        System.out.println("LEVEL IV - The Goblet of Fire");
        Core.printSeperator(60);
        System.out.println("By a lack of luck, you just won the 3 witch tournament...and the right to die.");
        System.out.println("You are in a cemetery, where lies Voldemort & Peter Pettigrew.");
        System.out.println("Your only chance of escaping is to get closer to Portkey and attract him (Accio!)");
        System.out.println("Don't worry ! You will see Voldemort another time.");
        System.out.println("Good luck ! ");

    }

    public static void fifthAct() {
        Core.printSeperator(60);
        System.out.println("LEVEL V - The Order of the Phenix");
        Core.printSeperator(60);
        System.out.println("It's the time of BUSE !");
        System.out.println("Dolores Ombrage watches over the grains. Your goal is to distract her while the fireworks are being set up.");
        System.out.println("Good luck ! ");

    }

    public static void sixthAct() {
        Core.printSeperator(60);
        System.out.println("LEVEL VI - The Half-Blood Prince");
        Core.printSeperator(60);
        System.out.println("Mangemorts have attacked Poudlard. Are you ready to defend yourself ?");
        System.out.println("You will need to attack them from straight ahead (Sectumsempra). If you are from Serpentard, you may join Mangemorts squad. ");
        System.out.println("Good luck ! ");

    }

    public static void seventhAct() {
        Core.printSeperator(60);
        System.out.println("LEVEL VII - The Deathly Hallows");
        Core.printSeperator(60);
        System.out.println("End of dithering, you need to attack the problem at its roots. You face Voldemort and Bellatric Lestrange.");
        System.out.println("Be careful ! They can kill you in one shot using Avada Kedavra if you are not ready.");
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

    public static void youDied() throws InterruptedException {
        clearConsole();
        Core.printSeperator(60);
        System.out.println("The boss killed you.");
        System.out.println("Thank you for playing Harry Potter at home by @Arthur Terisse");
        Core.printSeperator(60);
        Thread.sleep(3000);
        System.exit(0);
    }
}
