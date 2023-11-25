import java.util.Scanner;

public class StringAnalysis { // Change this class name to "Main" when you on litcoder

    public static void analyzeString(String str) {
        double uppercase = 0, lowercase = 0, digit = 0, specialChar = 0;
        int n = str.length();

        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                digit++;
            } else if (Character.isLowerCase(c)) {
                lowercase++;
            } else if (Character.isUpperCase(c)) {
                uppercase++;
            } else {
                specialChar++;
            }
        }

        printPercentage("Uppercase", uppercase, n);
        printPercentage("Lowercase", lowercase, n);
        printPercentage("Digit", digit, n);
        printPercentage("Special Character", specialChar, n);
    }

    public static void printPercentage(String category, double count, int total) {
        double percentage = (count / total) * 100;
        System.out.print(category + " ");
        System.out.println(percentage);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.println();
        analyzeString(input);
        scanner.close();
    }
}
