import java.util.Stack;

class PalindromeChecker {

    // Encapsulated method
    public boolean checkPalindrome(String input) {

        // Normalize string
        input = input.toLowerCase();
        input = input.replaceAll("\\s", "");

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        // Compare with stack pop
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

public class UC11Main {

    public static void main(String[] args) {

        String str = "Madam In Eden Im Adam";

        PalindromeChecker checker = new PalindromeChecker();

        if (checker.checkPalindrome(str)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}