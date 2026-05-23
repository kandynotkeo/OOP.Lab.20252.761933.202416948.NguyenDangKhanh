package hust.soict.hedspi.aims.media;

public class Track {
    // instance properties
    private String title;
    private int length;

    // constructors
    public Track() {
        this(null, 0);
    }

    public Track(String title, int length) {
        this.title = sanitise(title);
        this.length = Math.max(length, 0);
    }

    // getters, setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = sanitise(title);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (length > 0) this.length = length;
    }

    // instance methods
    protected String sanitise(String input) {
        return input == null || input.isBlank() ? null : input;
    }

    public String formatTitle() {
        return title == null ? "unnamed" : title;
    }

    public String formatLength() {
        if (length <= 0) return "unavailable";
        int min = length / 60, sec = length % 60;
        return String.format("%d:%02d", min, sec);
    }

    public void play() {
        System.out.println("Playing track: " + formatTitle() + " (" + formatLength() + ")");
    }
}