package hust.soict.hedspi.lab01;

import java.util.Scanner;

public class AddMatrices {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows, cols, i, j;

        System.out.print("Number of rows: ");
        rows = input.nextInt();
        System.out.print("Number of columns: ");
        cols = input.nextInt();

        int[][] mat1 = new int[rows][cols];
        int[][] mat2 = new int[rows][cols];
        int[][] matSum = new int[rows][cols];

        System.out.println("Matrix A:");
        for (i = 0; i < rows; i++) for (j = 0; j < cols; j++) mat1[i][j] = input.nextInt();
        System.out.println("Matrix B:");
        for (i = 0; i < rows; i++) for (j = 0; j < cols; j++) mat2[i][j] = input.nextInt();

        System.out.println("Sum of A and B:");
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                matSum[i][j] = mat1[i][j] + mat2[i][j];
                System.out.print(matSum[i][j] + " ");
            }
            System.out.println();
        }
        System.exit(0);
    }
}
