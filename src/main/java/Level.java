public class Level {

    static int lvlNumber;
    Enemy enemy;
    Location location;

    public Level(int lvlNumber, Enemy enemy, Location location) {
        Level.lvlNumber = lvlNumber;
        this.enemy = enemy;
        this.location = location;
    }

    public int getLvlNumber() {
        return lvlNumber;
    }


}
