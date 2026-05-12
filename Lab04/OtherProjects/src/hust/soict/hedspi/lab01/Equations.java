package hust.soict.hedspi.lab01;

import java.util.Scanner;

public class Equations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("[1] First-degree equation with one variable\n[2] First-degree equations system with two variables\n[3] Second-degree equation with one variable");
        do {
            System.out.print("Choose equation type: ");
            choice = input.nextInt();
        } while (choice < 1 || choice > 3);

        switch (choice) {
            case 1: {
                double a, b;
                System.out.print("1st-degree eq with 1 var: ax + b = 0\na, b: ");
                a = input.nextDouble();
                b = input.nextDouble();
                solve1stDegEq(a, b);
                break;
            }
            case 2: {
                double a11, a12, b1, a21, a22, b2;
                System.out.println("1st-degree eqs system with 2 vars: a11x1 + a12x2 = b1; a21x1 + a22x2 = b2");
                System.out.print("a11, a12, b1: ");
                a11 = input.nextDouble();
                a12 = input.nextDouble();
                b1 = input.nextDouble();
                System.out.print("a21, a22, b2: ");
                a21 = input.nextDouble();
                a22 = input.nextDouble();
                b2 = input.nextDouble();
                solve1stDegEqs(a11, a12, b1, a21, a22, b2);
                break;
            }
            case 3: {
                double a, b, c;
                System.out.print("2nd-degree eq with 1 var: ax^2 + bx + c = 0\na, b, c: ");
                a = input.nextDouble();
                b = input.nextDouble();
                c = input.nextDouble();
                solve2ndDegEq(a, b, c);
                break;
            }
            default:
                break;
        }

        System.exit(0);
    }

    static void solve1stDegEq(double a, double b) {
        if (a == 0)
            if (b == 0) System.out.println("Every real numbers.");
            else System.out.println("No solution.");
        else System.out.println("x = " + -b / a);
    }

    static void solve1stDegEqs(double a11, double a12, double b1, double a21, double a22, double b2) {
        double det = a11 * a22 - a12 * a21;
        if (det == 0)
            if (a11 / a21 == b1 / b2) System.out.println("x1; x2 = " + -a11 / a12 + "x1 + " + b1 / a12);
            else System.out.println("No solution.");
        else {
            double D1 = a22 * b1 - a12 * b2, D2 = a11 * b2 - a21 * b1;
            System.out.println("x1 = " + D1 / det + ", x2 = " + D2 / det);
        }
    }

    static void solve2ndDegEq(double a, double b, double c) {
        if (a == 0) solve1stDegEq(b, c);
        else {
            double delta = b * b - 4 * a * c;
            if (delta < 0) System.out.println("No solution.");
            else if (delta == 0) System.out.println("x = " + -b / 2 / a);
            else {
                double dsr = Math.sqrt(delta);
                System.out.println("x1 = " + (-b - dsr) / 2 / a + "; x2 = " + (-b + dsr) / 2 / a);
            }
        }
    }
}