package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.Media;

import java.util.*;

public class Store {
    // instance properties
    private List<Media> itemsInStore = new ArrayList<Media>();

    // getters, setters
    public List<Media> getItemsInStore() {
        return itemsInStore;
    }

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

    public Media search(String title) {
        for (Media media : itemsInStore)
            if (media.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Media found in store.");
                return media;
            }
        System.out.println("Media not found in store.");
        return null;
    }

    public void print() {
        int order = 1;
        System.out.println("***********************STORE***********************");
        System.out.println("Items in store:");
        for (Media mediaInList : itemsInStore) System.out.println(order + ". " + mediaInList.toString());
        System.out.println("***************************************************");
    }
}