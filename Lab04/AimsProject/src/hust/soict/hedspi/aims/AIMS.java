package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Collections;
import java.util.Scanner;

public class AIMS {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initStore();

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 0);
    }

    private static void initStore() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", null, 0, 18.99);
        
        Book book1 = new Book("The Great Gatsby", "Classic", 10.99);
        book1.addAuthor("F. Scott Fitzgerald");
        
        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", "Quincy Jones", 0, 15.5);
        cd1.setArtist("Michael Jackson");
        cd1.addTrack(new Track("Billie Jean", 294));
        cd1.addTrack(new Track("Beat It", 258));

        store.addMedia(dvd1, dvd2, dvd3, book1, cd1);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3: ");
    }

    public static void viewStore() {
        int choice;
        do {
            store.print();
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4: ");
    }

    private static void seeMediaDetails() {
        System.out.print("Enter media title: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        if (media != null) {
            System.out.println(media.toString());
            mediaDetailsMenuHandler(media);
        } else {
            System.out.println("Media not found!");
        }
    }

    private static void mediaDetailsMenuHandler(Media media) {
        int choice;
        do {
            mediaDetailsMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    if (media instanceof DigitalVideoDisc) {
                        System.out.println("Current number of DVDs in cart: " + cart.countDVDs());
                    }
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media is not playable!");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2: ");
    }

    private static void addMediaToCart() {
        System.out.print("Enter media title to add: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        if (media != null) {
            cart.addMedia(media);
            if (media instanceof DigitalVideoDisc) {
                System.out.println("Current number of DVDs in cart: " + cart.countDVDs());
            }
        } else {
            System.out.println("Media not found!");
        }
    }

    private static void playMedia() {
        System.out.print("Enter media title to play: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else if (media != null) {
            System.out.println("This media is not playable!");
        } else {
            System.out.println("Media not found!");
        }
    }

    public static void updateStore() {
        System.out.println("1. Add media to store");
        System.out.println("2. Remove media from store");
        System.out.println("0. Back");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Add which type? 1. DVD, 2. CD, 3. Book");
            int type = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Category: ");
            String category = scanner.nextLine();
            System.out.print("Cost: ");
            double cost = scanner.nextDouble();
            scanner.nextLine();

            if (type == 1) {
                store.addMedia(new DigitalVideoDisc(title, category, null, 0, cost));
            } else if (type == 2) {
                store.addMedia(new CompactDisc(title, null, category, 0, cost));
            } else if (type == 3) {
                store.addMedia(new Book(title, category, cost));
            }
        } else if (choice == 2) {
            System.out.print("Enter title to remove: ");
            String title = scanner.nextLine();
            Media media = store.search(title);
            if (media != null) {
                store.removeMedia(media);
            } else {
                System.out.println("Media not found!");
            }
        }
    }

    public static void seeCurrentCart() {
        int choice;
        do {
            cart.print();
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    filterCart();
                    break;
                case 2:
                    sortCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMediaInCart();
                    break;
                case 5:
                    placeOrder();
                    choice = 0; // go back to main menu after ordering
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: 0-1-2-3-4-5: ");
    }

    private static void filterCart() {
        System.out.println("Filter by: 1. ID, 2. Title");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            Media m = cart.search(id);
            if (m != null) System.out.println(m.toString());
        } else if (choice == 2) {
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            Media m = cart.search(title);
            if (m != null) System.out.println(m.toString());
        }
    }

    private static void sortCart() {
        System.out.println("Sort by: 1. Title, 2. Cost");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) {
            Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
        } else if (choice == 2) {
            Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
        }
        cart.print();
    }

    private static void removeMediaFromCart() {
        System.out.print("Enter title to remove: ");
        String title = scanner.nextLine();
        Media media = cart.search(title);
        if (media != null) {
            cart.removeMedia(media);
        }
    }

    private static void playMediaInCart() {
        System.out.print("Enter title to play: ");
        String title = scanner.nextLine();
        Media media = cart.search(title);
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else if (media != null) {
            System.out.println("This media is not playable!");
        }
    }

    private static void placeOrder() {
        System.out.println("Order has been created successfully!");
        cart.empty();
    }
}
