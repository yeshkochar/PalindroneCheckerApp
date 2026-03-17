import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
}

// Stack Strategy
class StackStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        input = input.toLowerCase().replaceAll("\\s", "");

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Deque Strategy
class DequeStrategy implements PalindromeStrategy {

    public boolean check(String input) {

        input = input.toLowerCase().replaceAll("\\s", "");

        Deque<Character> dq = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            dq.addLast(c);
        }

        while (dq.size() > 1) {
            if (dq.removeFirst() != dq.removeLast()) {
                return false;
            }
        }

        return true;
    }
}

// Context class
class PalindromeService {

    private PalindromeStrategy strategy;

    public PalindromeService(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String input) {
        return strategy.check(input);
    }
}

// Main class
public class UC12 {

    public static void main(String[] args) {

        String str = "Madam In Eden Im Adam";

        // choose strategy at runtime

        PalindromeStrategy strategy;

        // change here to test
        strategy = new StackStrategy();
        // strategy = new DequeStrategy();

        PalindromeService service =
                new PalindromeService(strategy);

        if (service.checkPalindrome(str)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}