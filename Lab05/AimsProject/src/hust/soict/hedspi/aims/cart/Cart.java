package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.*;

import java.util.*;

public class Cart {
    // instance properties
    private List<Media> itemsOrdered = new ArrayList<Media>();

    // getters, setters
    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    // instance methods
    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) System.out.println("Media is already in cart.");
        else {
            itemsOrdered.add(media);
            System.out.println("Added to cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed from cart.");
            return;
        }
        System.out.println("Not exist in cart.");
    }

    public void empty() {
        itemsOrdered.clear();
        System.out.println("Cart has been emptied.");
    }

    public int countDVDs() {
        int count = 0;
        for (Media media : itemsOrdered) if (media instanceof DigitalVideoDisc) count++;
        return count;
    }

    public Media search(int id) {
        for (Media mediaInList : itemsOrdered)
            if (mediaInList.getId() == id) {
                System.out.println("Media found in cart.");
                return mediaInList;
            }
        System.out.println("Media not found in cart.");
        return null;
    }

    public Media search(String title) {
        for (Media mediaInList : itemsOrdered)
            if (mediaInList.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Media found in cart.");
                return mediaInList;
            }
        System.out.println("Media not found in cart.");
        return null;
    }

    public void print() {
        int order = 1;
        System.out.println("***********************CART***********************");
        System.out.println("Ordered items:");
        for (Media mediaInList : itemsOrdered) System.out.println(order + ". " + mediaInList.toString());
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public double totalCost() {
        double cost = 0;
        for (Media mediaInList : itemsOrdered) cost += mediaInList.getCost();
        return cost;
    }
}