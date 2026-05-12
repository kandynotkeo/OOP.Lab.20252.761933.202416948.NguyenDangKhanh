package hust.soict.hedspi.lab01;

import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String name;
        int age;
        double height;

        System.out.print("Kimi no na wa: ");
        name = input.nextLine();
        System.out.print("Age: ");
        age = input.nextInt();
        System.out.print("Height (m): ");
        height = input.nextDouble();

        System.out.println("Mr./Mrs. " + name + ", " + age + " years old, " + height + "m tall.");
        System.exit(0);
    }
}
