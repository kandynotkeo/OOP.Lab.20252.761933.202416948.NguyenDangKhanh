package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.screen.StoreScreen;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;

public class GUITest {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    public static void main(String[] args) {
        initStore();

        new StoreScreen(store, cart);
    }

    private static void initStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Roger Allers", "Animation", 87, 19.95);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Interstellar", "Christopher Nolan", "Science Fiction", 169, 21.99);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Star Wars", "George Lucas", "Science Fiction", 87, 24.95);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladdin", null, "Animation", 0, 18.99);

        Book book1 = new Book("The Great Gatsby", "Classic", 10.99);
        book1.addAuthor("F. Scott Fitzgerald");

        CompactDisc cd1 = new CompactDisc("Thriller", "Quincy Jones", "Pop", 0, 15.5);
        cd1.setArtist("Michael Jackson");
        cd1.addTrack(new Track("Billie Jean", 294));
        cd1.addTrack(new Track("Beat It", 258));

        store.addMedia(dvd1, dvd2, dvd3, dvd4, book1, cd1);
    }
}
