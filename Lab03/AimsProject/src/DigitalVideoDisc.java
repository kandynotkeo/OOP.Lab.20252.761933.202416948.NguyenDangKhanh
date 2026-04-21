public class DigitalVideoDisc {
    // classifier properties
    private static int nbDigitalVideoDiscs = 0;

    // instance properties
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // constructors
    public DigitalVideoDisc() {
        nbDigitalVideoDiscs++;
        id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title) {
        this();
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title);
        this.category = category;
        this.cost = cost;
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
    public int getId() {
        return id;
    }

    public String getTitle() {
        if (title == null || title.isEmpty()) return "Unknown";
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        if (title == null) return "Unclassified";
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    // instance methods
    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + (length < 0 ? "N/A" : length + " mins") + ": " + (cost < 0 ? "N/A" : cost + "$");
    }
}