import java.util.Random;

public class Character {

    int hp;

    public void attack(Spell spellName, Character enemyName) {
        Random rand = new Random();
        enemyName.hp -= (spellName.damage * rand.nextFloat(0.5F, 1));
    }
}
