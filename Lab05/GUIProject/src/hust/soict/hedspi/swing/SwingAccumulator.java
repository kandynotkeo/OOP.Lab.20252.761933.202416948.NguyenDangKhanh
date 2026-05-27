package hust.soict.hedspi.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {
    private final JTextField tfInput;
    private final JTextField tfOutput;
    private int sum = 0;

    public SwingAccumulator() {
        Container cp = getContentPane();
        cp.setLayout(new GridLayout(2, 2));

        cp.add(new JLabel("Enter an Integer: "));

        tfInput = new JTextField(10);
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        cp.add(new JLabel("Accumulated sum: "));

        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Swing Accumulator");
        setSize(512, 128);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SwingAccumulator();
    }

    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            int inNum = Integer.parseInt(tfInput.getText());
            sum += inNum;
            tfInput.setText("");
            tfOutput.setText(sum + "");
        }
    }
}
