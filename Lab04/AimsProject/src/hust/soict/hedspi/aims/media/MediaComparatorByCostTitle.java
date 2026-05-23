package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media a, Media b) {
        return Comparator.comparing(Media::getCost, Comparator.reverseOrder()).thenComparing(Media::getTitle, Comparator.nullsLast(Comparator.naturalOrder())).compare(a, b);
    }
}