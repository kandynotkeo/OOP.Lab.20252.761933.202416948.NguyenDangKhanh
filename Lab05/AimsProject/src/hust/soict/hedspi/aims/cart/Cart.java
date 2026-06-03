package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Cart {
    // instance properties
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    // getters, setters
    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    // instance methods
    public String addMedia(Media media) {
        if (itemsOrdered.contains(media)) return "media is already in cart.";
        itemsOrdered.add(media);
        return "added to cart.";
    }

    public String removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            return ("removed from cart.");
        }
        return ("media is not exist in cart.");
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