package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    // classifier properties
    public static final int MAX_NUMBERS_IN_STORE = 50;

    // instance properties
    private List<Media> itemsInStore = new ArrayList<Media>();

    // instance methods
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) System.out.println("Media is already in store.");
        else {
            itemsInStore.add(media);
            System.out.println("Added to store.");
        }
    }

    public void addMedia(Media... mediaList) {
        for (Media media : mediaList) addMedia(media);
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println("Removed from store.");
            return;
        }
        System.out.println("Not exist in store.");
    }

    public void print() {
        int order = 1;
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media mediaInList : itemsInStore) System.out.println(order + ". " + mediaInList.getTitle());
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public double totalCost() {
        double cost = 0f;
        for (Media mediaInList : itemsInStore) cost += mediaInList.getCost();
        return cost;
    }
}