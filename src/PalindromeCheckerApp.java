public class PalindromeCheckUC4_Version2 {

    public static void main(String[] args) {

        String original = "racecar";

        // Convert String to char array
        char[] chars = original.toCharArray();

        boolean isPalindrome = true;

        // Two-pointer using for loop
        for (int i = 0; i < chars.length / 2; i++) {

            if (chars[i] != chars[chars.length - 1 - i]) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println(original + " is a Palindrome.");
        } else {
            System.out.println(original + " is NOT a Palindrome.");
        }
    }
}