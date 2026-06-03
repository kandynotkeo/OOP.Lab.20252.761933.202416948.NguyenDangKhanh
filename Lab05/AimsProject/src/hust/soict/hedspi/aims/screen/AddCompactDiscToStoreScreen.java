package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist = new JTextField(15);
    private JTextField tfDirector = new JTextField(15);

    public AddCompactDiscToStoreScreen(Store store) {
        super(store, "CD");

        centerPanel.add(new JLabel("Director:"));
        centerPanel.add(tfDirector);
        centerPanel.add(new JLabel("Artist:"));
        centerPanel.add(tfArtist);

        setVisible(true);
    }

    @Override
    protected void handleAdd() {
        try {
            String title = tfTitle.getText().trim();
            String category = tfCategory.getText().trim();
            double cost = Double.parseDouble(tfCost.getText().trim());
            String director = tfDirector.getText().trim();
            String artist = tfArtist.getText().trim();

            CompactDisc cd = new CompactDisc(title, director, category, 0, cost);
            cd.setArtist(artist);
            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "CD added successfully!");
            dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid cost value!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
