package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class Store {
    // classifier properties
    public static final int MAX_NUMBERS_IN_STORE = 50;

    // instance properties
    private int qtyInStore = 0;
    private final DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_NUMBERS_IN_STORE];

    // instance methods
    public void addDVD(DigitalVideoDisc disc) {
        if (qtyInStore >= MAX_NUMBERS_IN_STORE) {
            System.out.println("The store is full.");
            return;
        }
        itemsInStore[qtyInStore] = disc;
        qtyInStore++;
        System.out.println("Added to store.");
    }

    public void addDVD(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc disc : dvdList) addDVD(disc);
    }

    public void removeDVD(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyInStore; i++)
            if (itemsInStore[i] == disc) {
                qtyInStore--;
                for (int j = i; j < qtyInStore; j++) itemsInStore[j] = itemsInStore[j + 1];
                itemsInStore[qtyInStore] = null;
                System.out.println("Removed from store.");
                return;
            }
        System.out.println("Not exist in store.");
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyInStore; i++) System.out.println((i + 1) + ". " + itemsInStore[i].toString());
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public float totalCost() {
        float cost = 0f;
        for (int i = 0; i < qtyInStore; i++)
            cost += itemsInStore[i].getCost();
        return cost;
    }
}