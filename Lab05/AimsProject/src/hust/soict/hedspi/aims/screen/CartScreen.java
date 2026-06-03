package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.AimsApp;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.screen.controller.CartScreenController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CartScreen extends JPanel {
    private static boolean fxInitialized = false;
    static {
        Platform.setImplicitExit(false);
    }

    private Cart cart;
    private AimsApp app;
    private JFXPanel fxPanel;

    public CartScreen(Cart cart, AimsApp app) {
        this.cart = cart;
        this.app = app;
        setLayout(new BorderLayout());

        add(createHeader(), BorderLayout.NORTH);

        fxPanel = new JFXPanel();
        fxPanel.setPreferredSize(new Dimension(800, 600));
        add(fxPanel, BorderLayout.CENTER);

        Platform.runLater(this::initFx);
    }

    private void initFx() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/cart.fxml"));
            CartScreenController controller = new CartScreenController(cart, app);
            loader.setController(controller);
            Parent root = loader.load();
            fxPanel.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> {
            revalidate();
            repaint();
        });
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(Color.WHITE);
        header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

        JButton backBtn = new JButton("Back to Store");
        backBtn.setBorderPainted(false);
        backBtn.setContentAreaFilled(false);
        backBtn.setFocusPainted(false);
        backBtn.setCursor(java.awt.Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.setFont(new Font(backBtn.getFont().getName(), Font.PLAIN, 14));
        backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.showStore();
            }
        });

        JLabel title = new JLabel("Cart");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 16));
        title.setForeground(Color.CYAN);

        JLabel spacer = new JLabel();
        header.add(backBtn, BorderLayout.WEST);
        header.add(spacer, BorderLayout.CENTER);
        header.add(title, BorderLayout.EAST);

        header.setPreferredSize(new Dimension(0, 40));
        return header;
    }
}
