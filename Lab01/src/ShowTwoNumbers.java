import javax.swing.JOptionPane;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum, strNoti = "Two numbers: ";

        strNum = JOptionPane.showInputDialog(null, "First number: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        strNoti += strNum + " and ";

        strNum = JOptionPane.showInputDialog(null, "Second number: ", "Input", JOptionPane.INFORMATION_MESSAGE);
        strNoti += strNum;

        JOptionPane.showMessageDialog(null, strNoti, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
