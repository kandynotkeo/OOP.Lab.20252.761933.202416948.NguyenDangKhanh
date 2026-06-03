package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store, "Book");
        setVisible(true);
    }

    @Override
    protected void handleAdd() {
        try {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            double cost = Double.parseDouble(tfCost.getText().trim());

            Book book = new Book(title, category, cost);
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added successfully!");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid cost value!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
