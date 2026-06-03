package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.screen.CartScreen;
import hust.soict.hedspi.aims.screen.StoreScreen;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;

public class AimsApp {
    private JFrame mainFrame;
    private Store store;
    private Cart cart;

    public AimsApp(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        mainFrame = new JFrame("AIMS");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1024, 768);
        showStore();
    }

    public Store getStore() {
        return store;
    }

    public Cart getCart() {
        return cart;
    }

    private CartScreen cartScreen;

    public void showStore() {
        mainFrame.getContentPane().removeAll();
        mainFrame.setContentPane(new StoreScreen(store, cart, this));
        mainFrame.revalidate();
        mainFrame.repaint();
        mainFrame.setVisible(true);
    }

    public void showCart() {
        mainFrame.getContentPane().removeAll();
        if (cartScreen == null) {
            cartScreen = new CartScreen(cart, this);
        }
        mainFrame.setContentPane(cartScreen);
        mainFrame.revalidate();
        mainFrame.repaint();
        mainFrame.setVisible(true);
    }
}
