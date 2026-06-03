package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;
import java.util.*;

public class Track implements Playable {
    private String title;
    private int length;

    public Track(String title, int length) {
        this.title = sanitise(title);
        this.length = Math.max(length, 0);
    }

    public int getLength() {
        return length;
    }

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

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + formatTitle() + " (" + formatLength() + ")");
        } else {
            System.err.println("ERROR: Track length is non-positive!");
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Track)) return false;
        Track other = (Track) obj;
        if (this.title == null || other.title == null) return false;
        return this.title.equals(other.title) && this.length == other.length;
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
