package hust.soict.hedspi.aims.media;


import java.util.*;

public class Track implements Playable {
    // instance properties
    private String title;
    private int length;

    // constructors
    public Track(String title, int length) {
        this.title = sanitise(title);
        this.length = Math.max(length, 0);
    }

    public int getLength() {
        return length;
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

    protected Map<String, Object> getDetails() {
        Map<String, Object> details = new HashMap<>();
        details.put("title", formatTitle());
        details.put("length", formatLength());
        return details;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": " + getDetails().toString();
    }
}