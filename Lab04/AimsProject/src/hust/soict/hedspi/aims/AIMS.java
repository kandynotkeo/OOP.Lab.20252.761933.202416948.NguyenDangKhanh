package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.*;

import java.util.ArrayList;
import java.util.List;

public class AIMS {
    public static void main(String[] args) {
        DigitalVideoDisc dvd = new DigitalVideoDisc(null, null, null, 0, 4);
        CompactDisc cd = new CompactDisc("a CD", null, null, 0, 3);
        List<Media> media = new ArrayList<Media>();
        media.add(dvd);
        media.add(cd);

        System.out.println(media);
        media.sort(Media.COMPARE_BY_TITLE_COST);
        System.out.println(media);
        media.sort(Media.COMPARE_BY_COST_TITLE);
        System.out.println(media);
    }
}