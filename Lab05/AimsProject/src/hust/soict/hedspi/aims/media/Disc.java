package hust.soict.hedspi.aims.media;

import java.util.Map;

public class Disc extends Media {
    private String director;
    private int length;

    public Disc(int id, String title, String director, String category, int length, double cost) {
        super(id, title, category, cost);
        this.director = sanitise(director);
        this.length = Math.max(length, 0);
    }

    public int getLength() {
        return length;
    }

    public String formatDirector() {
        return director == null ? "anonymous" : director;
    }

    public String formatLength() {
        if (length <= 0) return "unavailable";
        int min = length / 60, sec = length % 60;
        return String.format("%d:%02d", min, sec);
    }

    protected Map<String, Object> getDetails() {
        Map<String, Object> details = super.getDetails();
        details.put("director", formatDirector());
        details.put("length", formatLength());
        return details;
    }
}
