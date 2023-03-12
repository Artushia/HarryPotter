public class Spell {

    String name;
    double percentSuccess;
    float damage;

    public Spell(String name, double percentSuccess, int damage) {
        this.name = name;
        this.percentSuccess = percentSuccess;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return name;
    }
}


