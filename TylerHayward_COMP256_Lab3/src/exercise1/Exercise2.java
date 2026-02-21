package exercise1;
import java.util.Scanner;

public class Exercise2 {

    // Recursive method
    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true; // Base case
        }

        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }

        return isPalindrome(s.substring(1, s.length() - 1));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String userInput = input.nextLine();

        if (isPalindrome(userInput)) {
            System.out.println(userInput + " is a palindrome.");
        } else {
            System.out.println(userInput + " is NOT a palindrome.");
        }

        input.close();
    }
}