import javax.swing.JOptionPane;

public class HelloNameDialog {
    public static void main(String[] args) {
        String result;
        result = JOptionPane.showInputDialog("Kimi no na wa:");
        JOptionPane.showMessageDialog(null, "Hello " + result + "!");
        System.exit(0);
    }
}
