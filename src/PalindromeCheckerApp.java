class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

class PalindromeLinkedList {

    Node head;

    // Convert string to linked list
    void insert(char c) {
        Node newNode = new Node(c);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Reverse linked list
    Node reverse(Node node) {
        Node prev = null;
        Node curr = node;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Check palindrome
    boolean isPalindrome() {

        if (head == null || head.next == null)
            return true;

        Node slow = head;
        Node fast = head;

        // Find middle using fast & slow pointer
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalf = reverse(slow.next);

        Node firstHalf = head;
        Node temp = secondHalf;

        // Compare halves
        while (temp != null) {
            if (firstHalf.data != temp.data) {
                return false;
            }
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        return true;
    }

    public static void main(String[] args) {

        String str = "madam";

        PalindromeLinkedList list = new PalindromeLinkedList();

        // Convert string to linked list
        for (int i = 0; i < str.length(); i++) {
            list.insert(str.charAt(i));
        }

        if (list.isPalindrome()) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }
}