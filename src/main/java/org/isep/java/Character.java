package org.isep.java;

import java.util.Random;
import lombok.Getter;
import lombok.Setter;
public abstract class Character {

    static Random rand = new Random();
    @Getter
    @Setter
    int hp;
    @Getter
    @Setter
    int damage;

    public Character(int hp, int damage) {
        this.hp = hp;
        this.damage = damage;
    }

        public static void attack(Spell spellName, Character attacker, Character defender) {

            int bonus = 0;
            //Specificity of GRYFFINDOR house -> higher resistance from damage
            if (defender instanceof Wizard) {
                if (((Wizard) defender).house.toString().equals("GRYFFINDOR")) {
                    bonus = 5;
                }
            }

            defender.hp -= ((attacker.damage * getRandomZeroOne(spellName.percentSuccess)) - bonus);
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        //Method that return 0 if random float is less than 1 - percent success or 1 if random float is higher than 1 - percent success
        public static int getRandomZeroOne(double percentSuccess) {
            return (rand.nextDouble() >= (1 - percentSuccess)) ? 1 : 0;
        }
    }

