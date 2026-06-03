package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        String mTitle = "", mCost = "0$";
        if (media != null) {
            mTitle = media.getTitle();
            mCost = media.getCost() + "$";
        }

        JLabel title = new JLabel(mTitle);
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(mCost);
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartBtn = new JButton("add to Cart");
        addToCartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cart.addMedia(media);
            }
        });
        container.add(addToCartBtn);

        if (media instanceof Playable) {
            JButton playBtn = new JButton("play");
            playBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    try {
                        ((Playable) media).play();
                        JDialog playDialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(MediaStore.this), "Play", true);
                        playDialog.setLayout(new BorderLayout());
                        JLabel msg = new JLabel("Playing: " + media.getTitle(), SwingConstants.CENTER);
                        msg.setFont(new Font(msg.getFont().getName(), Font.PLAIN, 20));
                        playDialog.add(msg, BorderLayout.CENTER);
                        JButton ok = new JButton("OK");
                        ok.addActionListener(e -> playDialog.dispose());
                        playDialog.add(ok, BorderLayout.SOUTH);
                        playDialog.setSize(300, 150);
                        playDialog.setLocationRelativeTo(MediaStore.this);
                        playDialog.setVisible(true);
                    } catch (PlayerException e) {
                        JOptionPane.showMessageDialog(MediaStore.this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
            container.add(playBtn);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
