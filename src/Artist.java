package src;

public class Artist {
    int id;
    String name;
    String categories;

    public Artist(int id, String name, String categories) {
        this.id = id;
        this.name = name;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return name + " (" + categories + ")";
    }
}
