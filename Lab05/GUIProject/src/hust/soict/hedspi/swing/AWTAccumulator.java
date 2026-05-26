package hust.soict.hedspi.swing;

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
    private final TextField tfInput;
    private final TextField tfOutput;
    private int sum = 0;

    public AWTAccumulator() {
        setLayout(new GridLayout(2, 2));

        add(new Label("Enter an Integer: "));

        tfInput = new TextField(10);
        add(tfInput);
        tfInput.addActionListener(new TFInputListener());

        add(new Label("Accumulated sum: "));

        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

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

        setTitle("AWT Accumulator");
        setSize(512, 128);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AWTAccumulator();
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