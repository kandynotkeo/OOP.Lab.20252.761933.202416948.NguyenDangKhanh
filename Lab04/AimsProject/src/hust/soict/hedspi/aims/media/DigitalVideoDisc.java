package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media {
    // classifier properties
    private static int nbDigitalVideoDiscs = 0;

    // instance properties
    private String director;
    private int length;

    // constructors
    public DigitalVideoDisc() {
        super();
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title) {
        this();
        setTitle(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title);
        setCategory(category);
        setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title, category, director, cost);
        this.length = length;
    }

    // classifier methods
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    // getters, setters
    public String getDirector() {
        if (director == null) return "Anonymous";
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

    // instance methods
    @Override
    public String toString() {
        float cost = getCost();
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + (length < 0 ? "N/A" : length + " mins") + ": " + (cost < 0 ? "N/A" : cost + "$");
    }

    public boolean isMatch(String title) {
        return getTitle().equals(title);
    }
}