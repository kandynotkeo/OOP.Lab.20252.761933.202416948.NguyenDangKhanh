package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGrid extends JFrame {
    private JButton[] btnNums = new JButton[10];
    private JButton btnDel, btnReset;
    private JTextField tfDisplay;

    public NumberGrid() {
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        JPanel panelBtns = new JPanel(new GridLayout(4, 3));
        addButtons(panelBtns);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH);
        cp.add(panelBtns, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid");
        setSize(256, 256);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NumberGrid();
    }

    void addButtons(JPanel panelBtns) {
        ButtonListener btnListener = new ButtonListener();
        for (int i = 1; i <= 9; i++) {
            btnNums[i] = new JButton("" + i);
            panelBtns.add(btnNums[i]);
            btnNums[i].addActionListener(btnListener);
        }

        btnDel = new JButton("DEL");
        panelBtns.add(btnDel);
        btnDel.addActionListener(btnListener);

        btnNums[0] = new JButton("0");
        panelBtns.add(btnNums[0]);
        btnNums[0].addActionListener(btnListener);

        btnReset = new JButton("C");
        panelBtns.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String btn = ae.getActionCommand();
            if (btn.charAt(0) >= '0' && btn.charAt(0) <= '9') tfDisplay.setText(tfDisplay.getText() + btn);
            else if (btn.equals("DEL")) {
                String current = tfDisplay.getText();
                tfDisplay.setText(current.substring(0, Math.max(current.length() - 1, 0)));
            } else tfDisplay.setText("");
        }
    }
}
