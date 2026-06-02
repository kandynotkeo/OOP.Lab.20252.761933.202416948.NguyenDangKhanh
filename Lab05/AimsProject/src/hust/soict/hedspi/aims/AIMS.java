package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.*;

public class AIMS {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initStore();
        while (true) {
            showMenu();
            int choice = makeChoice();
            if (choice < 0 || choice > 3) {
                System.out.println("invalid choice.");
                continue;
            }
            if (choice == 1) viewStore();
            else if (choice == 2) updateStore();
            else if (choice == 3) checkCart();
            else {
                System.out.println("ciao.");
                break;
            }
        }
    }

    private static void initStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", null, 0, 18.99);

        Book book1 = new Book("The Great Gatsby", "Classic", 10.99);
        book1.addAuthor("F. Scott Fitzgerald");

        CompactDisc cd1 = new CompactDisc("Thriller", "Quincy Jones", "Pop", 0, 15.5);
        cd1.setArtist("Michael Jackson");
        cd1.addTrack(new Track("Billie Jean", 294));
        cd1.addTrack(new Track("Beat It", 258));

        store.addMedia(dvd1, dvd2, dvd3, book1, cd1);
    }

    public static void showMenu() {
        System.out.println("AIMS");
        System.out.println("--------------------------------");
        System.out.println("1. view store");
        System.out.println("2. update store");
        System.out.println("3. check cart");
        System.out.println("0. exit");
        System.out.println("--------------------------------");
        System.out.print("choose a number [0-3]: ");
    }

    public static void viewStore() {
        while (true) {
            store.print();
            storeMenu();
            int choice = makeChoice();
            if (choice < 0 || choice > 4) {
                System.out.println("invalid choice.");
                continue;
            }
            if (choice == 1) seeMediaDetails();
            else if (choice == 2) addMediaToCart();
            else if (choice == 3) playMedia();
            else if (choice == 4) checkCart();
            else break;
        }
    }

    public static void storeMenu() {
        System.out.println("options");
        System.out.println("--------------------------------");
        System.out.println("1. see a media’s details");
        System.out.println("2. add a media to cart");
        System.out.println("3. play a media");
        System.out.println("4. check cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("choose a number [0-4]: ");
    }

    private static void seeMediaDetails() {
        System.out.print("media title: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        if (media != null) {
            System.out.println(media);
            mediaDetailsMenuHandler(media);
        }
    }

    private static void mediaDetailsMenuHandler(Media media) {
        while (true) {
            mediaDetailsMenu();
            int choice = makeChoice();
            if (choice < 0 || choice > 2) {
                System.out.println("invalid choice.");
                continue;
            }
            if (choice == 1) {
                cart.addMedia(media);
                if (media instanceof DigitalVideoDisc)
                    System.out.println("current number of DVDs in cart: " + cart.countDVDs());
            } else if (choice == 2)
                if (media instanceof Playable) ((Playable) media).play();
                else System.out.println("media is not playable.");
            else break;
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("options");
        System.out.println("--------------------------------");
        System.out.println("1. add to cart");
        System.out.println("2. play");
        System.out.println("0. back");
        System.out.println("--------------------------------");
        System.out.print("choose a number [0-2]: ");
    }

    private static void addMediaToCart() {
        System.out.print("media title to add: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        if (media != null) {
            cart.addMedia(media);
            if (media instanceof DigitalVideoDisc)
                System.out.println("current number of DVDs in cart: " + cart.countDVDs());
        }
    }

    private static void playMedia() {
        System.out.print("media title to play: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        if (media instanceof Playable) ((Playable) media).play();
        else if (media != null) System.out.println("media is not playable.");
    }

    public static void updateStore() {
        while (true) {
            System.out.println("1. add media to store");
            System.out.println("2. remove media from store");
            System.out.println("0. back");

            int choice = makeChoice();
            if (choice < 0 || choice > 2) {
                System.out.println("invalid choice.");
                continue;
            }
            if (choice == 1) {
                System.out.println("type to add: 1. DVD, 2. CD, 3. Book");
                int type = makeChoice();
                if (type < 1 || type > 3) {
                    System.out.println("invalid type.");
                    continue;
                }
                System.out.println("title: ");
                String title = scanner.nextLine();
                System.out.println("category: ");
                String category = scanner.nextLine();
                System.out.println("cost: ");
                double cost = 0;
                if (scanner.hasNextDouble()) cost = scanner.nextDouble();
                scanner.nextLine();
                if (type == 3) store.addMedia(new Book(title, category, cost));
                else {
                    System.out.println("director: ");
                    String director = scanner.nextLine();
                    if (type == 1) {
                        System.out.println("length: ");
                        int length = 0;
                        if (scanner.hasNextInt()) length = scanner.nextInt();
                        store.addMedia(new DigitalVideoDisc(title, director, category, length, cost));
                    } else store.addMedia(new CompactDisc(title, director, category, 0, cost));
                }
            } else if (choice == 2) {
                System.out.print("title to remove: ");
                String title = scanner.nextLine();
                Media media = store.search(title);
                if (media != null) store.removeMedia(media);
            } else break;
        }
    }

    public static void checkCart() {
        while (true) {
            cart.print();
            cartMenu();
            int choice = makeChoice();
            if (choice < 0 || choice > 5) {
                System.out.println("invalid choice.");
                continue;
            }
            if (choice == 1) filterCart();
            else if (choice == 2) sortCart();
            else if (choice == 3) removeMediaFromCart();
            else if (choice == 4) playMediaInCart();
            else if (choice == 5) {
                placeOrder();
                break;
            } else break;
        }
    }

    public static void cartMenu() {
        System.out.println("options");
        System.out.println("--------------------------------");
        System.out.println("1. filter medias in cart");
        System.out.println("2. sort medias in cart");
        System.out.println("3. remove media from cart");
        System.out.println("4. play a media");
        System.out.println("5. place order");
        System.out.println("0. back");
        System.out.println("--------------------------------");
        System.out.print("choose a number [0-5]: ");
    }

    private static void filterCart() {
        System.out.println("filter by: 1. ID, 2. title");
        int choice = makeChoice();
        if (choice == 1) {
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Media m = cart.search(id);
            if (m != null) System.out.println(m);
        } else if (choice == 2) {
            System.out.print("title: ");
            String title = scanner.nextLine();
            Media m = cart.search(title);
            if (m != null) System.out.println(m);
        } else System.out.println("invalid choice.");
    }

    private static void sortCart() {
        System.out.println("sort by: 1. title, 2. cost");
        int choice = makeChoice();
        if (choice == 1) cart.getItemsOrdered().sort(Media.COMPARE_BY_TITLE_COST);
        else if (choice == 2) cart.getItemsOrdered().sort(Media.COMPARE_BY_COST_TITLE);
        else System.out.println("invalid choice.");
        cart.print();
    }

    private static void removeMediaFromCart() {
        System.out.print("title to remove: ");
        String title = scanner.nextLine();
        Media media = cart.search(title);
        if (media != null) cart.removeMedia(media);
    }

    private static void playMediaInCart() {
        System.out.print("title to play: ");
        String title = scanner.nextLine();
        Media media = cart.search(title);
        if (media instanceof Playable) ((Playable) media).play();
        else if (media != null) System.out.println("media is not playable.");
    }

    private static void placeOrder() {
        System.out.println("order created.");
        cart.empty();
    }

    public static int makeChoice() {
        int choice = -1;
        if (scanner.hasNextInt()) choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
