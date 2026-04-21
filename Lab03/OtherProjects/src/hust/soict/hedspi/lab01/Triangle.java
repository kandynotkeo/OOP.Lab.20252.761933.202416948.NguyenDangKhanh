package hust.soict.hedspi.lab01;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int row;

        System.out.print("Height of triangle: ");
        row = input.nextInt();
        for (int i = 0; i < row; i++) {
            int blankLen = row - 1 - i;
            for (int j = 0; j < blankLen; j++) System.out.print(' ');
            for (int j = 0; j < 2 * i + 1; j++) System.out.print('*');
            for (int j = 0; j < blankLen; j++) System.out.print(' ');
            System.out.println();
        }

        System.exit(0);
    }
}