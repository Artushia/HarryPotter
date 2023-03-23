package org.isep.java.view;

import org.isep.java.model.Pet;
import org.isep.java.model.Core;

import java.util.Scanner;

import static java.lang.System.in;

public class WizardView {

    private final static Scanner sc = new Scanner(in);

    public static String choseName() {
        System.out.println("Hello! What is the name of your wizard? ");
        return sc.next();
    }

    public static int choseSize() {
        int size = 0;
        while ((size > 36) || (size < 24)) {
            System.out.println("Choose a size between 24 and 36 cm for your wand: ");
            size = sc.nextInt();
        }
        return size;
    }

    public static Core choseCore() {
        System.out.println("Enter the number corresponding to the desired core: ");
        for (int i=0; i<Core.values().length; i++) {
            System.out.println(i + " -> " + Core.values()[i]);}
        //Checks if value entered by user is correct
        int index = Core.values().length;
        while (index > Core.values().length - 1) {
            index = sc.nextInt();}
        return Core.values()[index];
    }

    public static Pet choosePet() {
        System.out.println("Enter the number corresponding to the desired pet: ");
        for (int i=0; i<Pet.values().length; i++) {
            System.out.println(i + " -> " + Pet.values()[i]);}
        //Checks if value entered by user is correct
        int chooseValue = Pet.values().length;
        while (chooseValue > Pet.values().length - 1) {
            chooseValue = sc.nextInt();}
        return Pet.values()[chooseValue];
    }
}
