import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.in;

public class Logic {

    public static void main(String[] args) {
        exeGame();
    }

    public static void exeGame() {
        createCharacter();
    }

    //Defines the feature of the wizard
    public static void createCharacter() {

        Wizard wizard = new Wizard();

        //Set Name
        System.out.println("Hello! What is the name of your wizard? ");
        Scanner sc = new Scanner(in);
        wizard.setName(sc.next());

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
        wizard.setWand(new Wand(core,size));

        //Set House
        SortingHat sortingHat = new SortingHat();
        wizard.setHouse(sortingHat.pickHouse());

        //Set Pet
        System.out.println("Enter the number corresponding to the desired pet: ");
        for (int i=0; i<Pet.values().length; i++) {
            System.out.println(i + " -> " + Pet.values()[i]);}
        //Checks if value entered by user is correct
        int chooseValue = Pet.values().length;
        while (chooseValue > Pet.values().length - 1) {
            chooseValue = sc.nextInt();}
        Pet pet = Pet.values()[chooseValue];
        wizard.setPet(pet);

        //TEST
        System.out.println(wizard);
    }

}
