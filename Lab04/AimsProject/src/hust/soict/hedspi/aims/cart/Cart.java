package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    // classifier properties
    public static final int MAX_NUMBERS_ORDERED = 20;

    // instance properties
    private List<Media> itemsOrdered = new ArrayList<Media>();

    // instance methods
    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) System.out.println("Media is already in cart.");
        else {
            itemsOrdered.add(media);
            System.out.println("Added to cart.");
        }
    }

    public void addMedia(Media... mediaList) {
        for (Media media : mediaList) addMedia(media);
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed from cart.");
            return;
        }
        System.out.println("Not exist in cart.");
    }

    public Media search(int id) {
        for (Media mediaInList : itemsOrdered)
            if (mediaInList.getId() == id) {
                System.out.println("Media found in cart.");
                return mediaInList;
            }
        System.out.println("DVD not found in cart.");
        return null;
    }

    public Media search(String title) {
        for (Media mediaInList : itemsOrdered)
            if (mediaInList.getTitle().equals(title)) {
                System.out.println("Media found in cart.");
                return mediaInList;
            }
        System.out.println("DVD not found in cart.");
        return null;
    }

    public void print() {
        int order = 1;
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media mediaInList : itemsOrdered) System.out.println(order + ". " + mediaInList.getTitle());
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public double totalCost() {
        double cost = 0f;
        for (Media mediaInList : itemsOrdered) cost += mediaInList.getCost();
        return cost;
    }
}