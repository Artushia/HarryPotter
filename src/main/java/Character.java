import java.util.Random;

public class Character {
    static Random rand = new Random();

    int hp;

    public void attack(Spell spellName, Character enemyName) {

        int bonus = 0;
        //Specificity of GRYFFINDOR house -> higher resistance from damage
        if (enemyName instanceof Wizard) {
            if (((Wizard) enemyName).house.toString().equals("GRYFFINDOR")) {
                bonus = 5;}}

        enemyName.hp -= ((spellName.damage * getRandomZeroOne(spellName.percentSuccess)) - bonus);
    }

    //Method that return 0 if random float is less than 1 - percent success or 1 if random float is higher than 1 - percent success
    public static int getRandomZeroOne(double percentSuccess) {
        return (rand.nextDouble() >= (1-percentSuccess)) ? 1 : 0;
    }
}
