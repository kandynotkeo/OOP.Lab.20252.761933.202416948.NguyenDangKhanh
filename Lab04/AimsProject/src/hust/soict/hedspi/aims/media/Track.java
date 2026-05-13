package hust.soict.hedspi.aims.media;

public class Track {
    // instance properties
    private String title;
    private int length;

    // constructors
    public Track() {
    }

    public Track(String title) {
        this();
        setTitle(title);
    }

    public Track(String title, int length) {
        this(title);
        setLength(length);
    }

    // getters, setters
    public String getTitle() {
        if (title == null || title.isEmpty()) return "Unknown";
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // instance methods
    public void play() {
        System.out.println("Playing track: " + getTitle() + " (" + getLength() + "s)");
    }
}
