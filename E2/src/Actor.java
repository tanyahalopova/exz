public class Actor {
    private int id;
    private String name;
    private int xp;

    public Actor(int id, String name, int xp) {
        this.id = id;
        this.name = name;
        this.xp = xp;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getXp() {
        return xp;
    }
}
