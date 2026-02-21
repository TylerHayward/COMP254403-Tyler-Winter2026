package exercise1;
import java.io.File;
import java.util.Scanner;

public class Exercise3 {

    // Recursive method
    public static void find(File path, String filename) {

        if (path == null || !path.exists()) {
            return;
        }

        if (path.isDirectory()) {
            File[] files = path.listFiles();

            if (files != null) {
                for (File file : files) {
                    find(file, filename); // Recursive call
                }
            }

        } else {
            if (path.getName().equals(filename)) {
                System.out.println("Found: " + path.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter starting directory path: ");
        String startPath = input.nextLine();

        System.out.print("Enter filename to search for: ");
        String filename = input.nextLine();

        File file = new File(startPath);

        find(file, filename);

        input.close();
    }
}