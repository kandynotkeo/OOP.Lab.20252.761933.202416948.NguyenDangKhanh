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

        setTitle("Swing Accumulator");
        setSize(512, 128);
        setVisible(true);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent windowEvent) {
                System.out.println("opened");
            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.out.println("closing");
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent windowEvent) {
                System.out.println("closed");
            }

            @Override
            public void windowIconified(WindowEvent windowEvent) {
                System.out.println("iconified");
            }

            @Override
            public void windowDeiconified(WindowEvent windowEvent) {
                System.out.println("deiconified");
            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {
                System.out.println("activated");
            }

            @Override
            public void windowDeactivated(WindowEvent windowEvent) {
                System.out.println("deactivated");
            }
        });
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
