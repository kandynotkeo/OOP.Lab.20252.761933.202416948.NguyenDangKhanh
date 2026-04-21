import javax.swing.plaf.synth.SynthTextAreaUI;

public class Cart {
    // classifier properties
    public static final int MAX_NUMBERS_ORDERED = 20;

    // instance properties
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    // instance methods
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full.");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered++;
        System.out.println("Added to cart.");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc... dvdList) {
        for (DigitalVideoDisc dvd : dvdList) addDigitalVideoDisc(dvd);
    }

/*
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
*/

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) itemsOrdered[j] = itemsOrdered[j + 1];
                qtyOrdered--;
                itemsOrdered[qtyOrdered] = null;
                System.out.println("Removed from cart.");
                return;
            }
        }
        System.out.println("Not exist in cart.");
    }

    public DigitalVideoDisc search(int id) {
        for (int i = 0; i < qtyOrdered; i++)
            if (itemsOrdered[i].getId() == id) {
                System.out.println("In cart: " + itemsOrdered[i].toString());
                return itemsOrdered[i];
            }
        System.out.println("DVD not found in cart.");
        return null;
    }

    public DigitalVideoDisc search(String title) {
        for (int i = 0; i < qtyOrdered; i++)
            if (itemsOrdered[i].isMatch(title)) {
                System.out.println("In cart: " + itemsOrdered[i].toString());
                return itemsOrdered[i];
            }
        System.out.println("DVD not found in cart.");
        return null;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) System.out.println((i + 1) + ". " + itemsOrdered[i].toString());
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public float totalCost() {
        float cost = 0f;
        for (int i = 0; i < qtyOrdered; i++)
            cost += itemsOrdered[i].getCost();
        return cost;
    }
}