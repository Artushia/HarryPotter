import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static java.lang.System.in;

public class Wizard extends Character{

    //specifications of the character
    String name;
    private Pet pet;
    Wand wand;
    House house;
    List<Spell> knownSpells = new ArrayList<>();
    private final List<Potion> potions = new ArrayList<>();

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

    //Defines the feature of the wizard
    public Wizard() {

        //Set Name
        System.out.println("Hello! What is the name of your wizard? ");
        Scanner sc = new Scanner(in);
        this.name = sc.next();

        //Set Wand
        int size = 0;
        while ((size > 36) || (size < 24)) {
            System.out.println("Choose a size between 24 and 36 cm for your wand: ");
            size = sc.nextInt();}
        System.out.println("Enter the number corresponding to the desired core: ");
        for (int i=0; i<Core.values().length; i++) {
            System.out.println(i + " -> " + Core.values()[i]);}
        //Checks if value entered by user is correct
        int index = Core.values().length;
        while (index > Core.values().length - 1) {
            index = sc.nextInt();}
        Core core = Core.values()[index];
        this.wand = new Wand(core,size);

        //Set House
        SortingHat sortingHat = new SortingHat();
        this.house = sortingHat.pickHouse();

        //Set Pet
        System.out.println("Enter the number corresponding to the desired pet: ");
        for (int i=0; i<Pet.values().length; i++) {
            System.out.println(i + " -> " + Pet.values()[i]);}
        //Checks if value entered by user is correct
        int chooseValue = Pet.values().length;
        while (chooseValue > Pet.values().length - 1) {
            chooseValue = sc.nextInt();}
        this.pet = Pet.values()[chooseValue];

        //Set HP
        this.hp = 100;

        //adds Wanguardium Leviosa by default at beginning of game
        Spell Leviosa = new Spell("Wanguardium Leviosa", 0.7, 25);
        knownSpells.add(Leviosa);
    }


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



