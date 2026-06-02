package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    // classifier properties
    private static int nbDigitalVideoDiscs = 0;

    // constructors
    public DigitalVideoDisc(String title, String director, String category, int length, double cost) {
        super(++nbDigitalVideoDiscs, title, director, category, length, cost);
    }

    // instance methods
    public void play() {
        System.out.println("Playing DVD: " + formatTitle() + " (" + formatLength() + ")");
    }
}