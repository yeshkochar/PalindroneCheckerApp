import java.util.Scanner;

public class PalindromeCheckerApp {
    /*
     * Complete the function below using if-else.
     * For only half the length (i / 2)
     */
    public static boolean isPalindrome(String input) {
        int j = input.length() - 1;
        for(int i = 0; i < input.length() / 2; i++) {
            if(input.charAt(i) == input.charAt(j)) {
                // Characters match, continue checking
                j--;
            } else {
                // Characters don't match, not a palindrome
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check if it's a palindrome: ");
        String input = scanner.nextLine();

        if(isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a palindrome!");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }
}
