package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc {
    // classifier properties
    private static int nbDigitalVideoDiscs = 0;

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
        setDirector(director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title, category, director, cost);
        setLength(length);
    }

    // classifier methods
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    // instance methods
    @Override
    public String toString() {
        float cost = getCost();
        int length = getLength();
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + (length < 0 ? "N/A" : length + " mins") + ": " + (cost < 0 ? "N/A" : cost + "$");
    }

    public boolean isMatch(String title) {
        return getTitle().equals(title);
    }
}