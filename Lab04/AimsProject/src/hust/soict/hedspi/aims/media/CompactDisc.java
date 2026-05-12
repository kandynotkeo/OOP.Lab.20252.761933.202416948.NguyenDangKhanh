package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc {
    // instance properties
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    // constructors
    public CompactDisc() {
        super();
    }

    // getters, setters
    public String getArtist() {
        return artist;
    }

    // instance methods
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

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) totalLength += track.getLength();
        return totalLength;
    }
}
