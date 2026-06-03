package hust.soict.hedspi.aims.media;

import java.util.*;
import hust.soict.hedspi.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable {
    private static int nbCompactDiscs = 0;

    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(String title, String director, String category, int length, double cost) {
        super(++nbCompactDiscs, title, director, category, length, cost);
    }

    public void setArtist(String artist) {
        this.artist = sanitise(artist);
    }

    public String formatArtist() {
        return artist == null ? "anonymous" : artist;
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) totalLength += track.getLength();
        return totalLength;
    }

    public String formatLength() {
        int totalLength = getLength();
        if (totalLength <= 0) return "unavailable";
        int min = totalLength / 60, sec = totalLength % 60;
        return String.format("%d:%02d", min, sec);
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            String artist = formatArtist();
            System.out.println("Playing CD: " + artist);
            Iterator iterator = tracks.iterator();
            while (iterator.hasNext()) {
                Track nextTrack = (Track) iterator.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e) {
                    throw e;
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
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
