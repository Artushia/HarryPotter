import java.util.ArrayList;
import java.util.List;

public class Wizard {

    //specifications of the character
    String name;
    private Pet pet;
    Wand wand;
    House house;
    private List<Spell> knownSpells = new ArrayList<>();
    private List<Potion> potions = new ArrayList<>();

    //Setters and Getters
    public void setName(String name) {this.name = name;}

    public void setHouse(House house) {this.house = house;}

    public void setWand(Wand wand) {this.wand = wand;}

    public void setPet(Pet pet) {this.pet = pet;}

    public Wand getWand() {return wand;}

    public String getName() {return name;}

    public List<Spell> getKnownSpells() {return knownSpells;}

    public void addSpell(Spell spell) {knownSpells.add(spell);}

    public void addPotion(Potion potion) {potions.add(potion);}


    @Override
    public String toString() {
        return "Wizard{" +
                "name='" + name + '\'' +
                ", pet=" + pet +
                ", wand=" + wand +
                ", house=" + house +
                '}';
    }
}



