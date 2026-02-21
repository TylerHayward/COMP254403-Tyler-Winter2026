package exercise1;
import java.util.Scanner;

public class exercise1 {

    // Recursive method
    public static int recursiveProduct(int m, int n) {
        if (n == 0) {
            return 0; // Base case
        }
        return m + recursiveProduct(m, n - 1); // Recursive case
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first positive integer (m): ");
        int m = input.nextInt();

        System.out.print("Enter second positive integer (n): ");
        int n = input.nextInt();

        int result = recursiveProduct(m, n);

        System.out.println("Product of " + m + " and " + n + " is: " + result);

        input.close();
    }
}