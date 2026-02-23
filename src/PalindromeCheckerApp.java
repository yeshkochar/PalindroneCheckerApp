import java.util.Deque;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String original = "noon";

        Deque<Character> deque = new LinkedList<>();

        // Insert characters into deque
        for (int i = 0; i < original.length(); i++) {
            deque.addLast(original.charAt(i));
        }

        boolean isPalindrome = true;

        // Remove first & last and compare
        while (deque.size() > 1) {

            char front = deque.removeFirst();  // Front removal
            char rear = deque.removeLast();    // Rear removal

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println(original + " is a Palindrome.");
        } else {
            System.out.println(original + " is NOT a Palindrome.");
        }
    }
}