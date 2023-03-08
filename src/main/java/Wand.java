import java.util.Scanner;

public class Wand {

    private final Core core;
    private final int size;

    //Constructor
    public Wand(Core core, int size) {
        this.core = core;
        this.size = size;
    }

    @Override
    public String toString() {
        return " Your wand's core is " + core + ", and size is " + size + " cm";
    }
}
