class UC10Palindrome {

    // Function to check palindrome
    static boolean isPalindrome(String str) {

        // 1. Normalize string
        str = str.toLowerCase();

        // 2. Remove spaces using regex
        str = str.replaceAll("\\s", "");

        // 3. Convert to char array
        char[] arr = str.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        // 4. Compare characters
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String input = "Madam In Eden Im Adam";

        if (isPalindrome(input)) {
            System.out.println("Palindrome (ignoring case & spaces)");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}