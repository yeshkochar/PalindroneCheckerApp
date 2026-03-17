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

// Performance comparison class
class PerformanceTest {

    static void test(PalindromeStrategy strategy,
                     String name,
                     String input) {

        long start = System.nanoTime();

        boolean result = strategy.check(input);

        long end = System.nanoTime();

        long time = end - start;

        System.out.println(
                name + " -> " + result +
                        " | Time: " + time + " ns");
    }
}

// Main class
public class UC13 {

    public static void main(String[] args) {

        String str = "Madam In Eden Im Adam";

        PalindromeStrategy stack =
                new StackStrategy();

        PalindromeStrategy deque =
                new DequeStrategy();

        PerformanceTest.test(
                stack,
                "Stack Strategy",
                str);

        PerformanceTest.test(
                deque,
                "Deque Strategy",
                str);
    }
}