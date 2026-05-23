package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;

import java.util.ArrayList;
import java.util.List;

public class AIMS {
    public static void main(String[] args) {
        DigitalVideoDisc dvd = new DigitalVideoDisc();
        CompactDisc cd = new CompactDisc();
        Book book = new Book();
        List<Media> media = new ArrayList<Media>();
        media.add(dvd);
        media.add(cd);
        media.add(book);
        for (Media m : media) {
            System.out.println(m.toString());
        }
    }
}