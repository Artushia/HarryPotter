public class Story {

    public static void firstAct() {
        Logic.printSeperator(60);
        System.out.println("LEVEL I - Dungeon's restroom");
        Logic.printSeperator(60);
        System.out.println("In this first level, you will need to use the Wingardium Leviosa spell");
        System.out.println("to raise objects above the troll's head.");
        System.out.println("Good luck !");

    }

    public static void winAgainstBoss(String bossName, int lvlNumber) {
        System.out.println("Congrats ! You killed the " + bossName + " ! ");
        System.out.println("You get to move on to level" + lvlNumber + " ! ");
    }
}
