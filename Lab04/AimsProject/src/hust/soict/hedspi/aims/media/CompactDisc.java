package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    // classifier properties
    private static int nbCompactDiscs = 0;

    // instance properties
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    // constructors
    public CompactDisc() {
        this(null, null, null, 0, 0);
    }

    public CompactDisc(String title, String director, String category, int length, double cost) {
        super(++nbCompactDiscs, title, director, category, length, cost);
    }

    // getters, setters
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = sanitise(artist);
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    // instance methods
    public String formatArtist() {
        return artist == null ? "anonymous" : artist;
    }

    public String formatLength() {
        int totalLength = 0;
        for (Track track : tracks) totalLength += track.getLength();
        if (totalLength <= 0) return "unavailable";
        int min = totalLength / 60, sec = totalLength % 60;
        return String.format("%d:%02d", min, sec);
    }

    public void play() {
        String artist = formatArtist();
        System.out.println("Playing CD: " + artist);
        for (Track track : tracks) track.play();
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track is already existed.");
            return;
        }
        tracks.add(track);
        System.out.println("Added to tracks.");
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Removed from tracks.");
        } else System.out.println("Track is not present.");
    }
}
