public class Film {
    private int id;
    private String name;
    private int year;
    private int directorId;

    public Film(int id, String name, int year, int directorId) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.directorId = directorId;
    }

    public int getDirectorId(){
        return directorId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }
}
