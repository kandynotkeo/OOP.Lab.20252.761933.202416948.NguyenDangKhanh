package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media a, Media b) {
        return Comparator.comparing(Media::getTitle, Comparator.nullsLast(Comparator.naturalOrder())).thenComparing(Media::getCost, Comparator.reverseOrder()).compare(a, b);
    }
}
