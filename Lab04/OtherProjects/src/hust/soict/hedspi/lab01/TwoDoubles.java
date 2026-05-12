package hust.soict.hedspi.lab01;

import java.util.Scanner;

public class TwoDoubles {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Two numbers: ");
        double num1 = input.nextDouble(), num2 = input.nextDouble();
        System.out.println("Sum: " + (num1 + num2));
        System.out.println("Difference: " + (num1 - num2));
        System.out.println("Product: " + num1 * num2);
        System.out.println("Quotient: " + num1 / num2);
        System.exit(0);
    }
}
