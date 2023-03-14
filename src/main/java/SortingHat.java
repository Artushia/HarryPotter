import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortingHat {

    List<House> houses;

    public SortingHat() {
        houses = new ArrayList<>();
        houses.add(new House("RAVENCLAW"));
        houses.add(new House("GRYFFINDOR"));
        houses.add(new House("SLYTHERIN"));
        houses.add(new House("HUFFLEPUFF"));
    }

    public House pickHouse() {
        Random random = new Random();
        int randomIndex = random.nextInt(houses.size());
        return houses.get(randomIndex);
    }

}
