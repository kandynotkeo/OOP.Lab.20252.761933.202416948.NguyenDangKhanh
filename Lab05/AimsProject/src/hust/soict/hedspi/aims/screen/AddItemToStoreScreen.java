package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.store.Store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JTextField tfTitle = new JTextField(15);
    protected JTextField tfCategory = new JTextField(15);
    protected JTextField tfCost = new JTextField(15);
    protected JPanel centerPanel = new JPanel(new GridLayout(0, 2, 5, 5));

    public AddItemToStoreScreen(Store store, String itemType) {
        this.store = store;
        setTitle("Add " + itemType);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        centerPanel.add(new JLabel("Title:"));
        centerPanel.add(tfTitle);
        centerPanel.add(new JLabel("Category:"));
        centerPanel.add(tfCategory);
        centerPanel.add(new JLabel("Cost:"));
        centerPanel.add(tfCost);

        add(centerPanel, BorderLayout.CENTER);

        JButton btnAdd = new JButton("Add " + itemType);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAdd();
            }
        });
        add(btnAdd, BorderLayout.SOUTH);
    }

    protected abstract void handleAdd();
}
