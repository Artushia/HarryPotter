public class House {

    String name;

    public House(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "House{" + "name='" + name + '\'' + '}';
    }
}
