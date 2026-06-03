package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector = new JTextField(15);
    private JTextField tfLength = new JTextField(15);

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "DVD");

        centerPanel.add(new JLabel("Director:"));
        centerPanel.add(tfDirector);
        centerPanel.add(new JLabel("Length:"));
        centerPanel.add(tfLength);

        setVisible(true);
    }

    @Override
    protected void handleAdd() {
        try {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            double cost = Double.parseDouble(tfCost.getText().trim());
            String director = tfDirector.getText().trim();
            int length = Integer.parseInt(tfLength.getText().trim());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, director, category, length, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD added successfully!");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid number format!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
