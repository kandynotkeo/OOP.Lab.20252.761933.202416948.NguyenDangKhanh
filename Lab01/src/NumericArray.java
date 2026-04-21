import java.util.Arrays;
import java.util.Scanner;

public class NumericArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int arrSize, arrSum = 0;

        System.out.print("Size of array: ");
        arrSize = input.nextInt();
        int[] arr = new int[arrSize];
        System.out.print("Elements of array: ");
        for (int i = 0; i < arrSize; i++) {
            arr[i] = input.nextInt();
            arrSum += arr[i];
        }

        for (int i = 0; i < arrSize; i++)
            for (int j = i + 1; j < arrSize; j++)
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

        System.out.println("Sum of array: " + arrSum);
        System.out.println("Average of array: " + arrSum / arrSize);
        System.out.println(Arrays.toString(arr));
        System.exit(0);
    }
}
