package hust.soict.hedspi.aims.media;

public class Track {
    // instance properties
    private String title;
    private int length;

    // constructors
    public Track() {
    }

    // getters, setters
    public String getTitle() {
        if (title == null || title.isEmpty()) return "Unknown";
        return title;
    }

    public int getLength() {
        return length;
    }
}
