package hust.soict.hedspi.aims.media;

public class Disc extends Media {
    // instance properties
    private String director;
    private int length;

    // constructors
    public Disc() {
        super();
    }

    // getters, setters
    public String getDirector() {
        if (director == null || director.isEmpty()) return "Anonymous";
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
