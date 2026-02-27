import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;

public class PalindromeCheckerApp {

    public static boolean isPalindromeRecursive(String str, int start, int end) {

        // Base condition
        if (start >= end) {
            return true;
        }

        // If characters don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    public static void main(String[] args){

        // UC1 – Welcome Message
        System.out.println("Welcome to Palimdrome Checker App mangement System");

        // UC2 – Hardcoded Palindrome Check
        String hardcodedWord = "madam";
        String reversedHardcoded = "";

        for (int i = hardcodedWord.length() - 1; i >= 0; i--) {
            reversedHardcoded = reversedHardcoded + hardcodedWord.charAt(i);
        }

        if (hardcodedWord.equals(reversedHardcoded)) {
            System.out.println("UC2 Result: " + hardcodedWord + " is a Palindrome");
        } else {
            System.out.println("UC2 Result: " + hardcodedWord + " is not a Palindrome");
        }

        // UC3 – Palindrome Check Using String Reverse
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check: ");
        String userWord = scanner.nextLine();

        String reversedUserWord = "";

        for (int i = userWord.length() - 1; i >= 0; i--) {
            reversedUserWord = reversedUserWord + userWord.charAt(i);
        }

        if (userWord.equals(reversedUserWord)) {
            System.out.println("UC3 Result: " + userWord + " is a Palindrome");
        } else {
            System.out.println("UC3 Result: " + userWord + " is not a Palindrome");
        }

        // UC4 – Character Array Based Palindrome Check


        System.out.println("-----------------------------------");
        System.out.print("Enter a string for UC4 check: ");

        String arrayWord = scanner.nextLine();

        char[] characters = arrayWord.toCharArray();

        int start = 0;
        int end = characters.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        if (isPalindrome) {
            System.out.println("UC4 Result: " + arrayWord + " is a Palindrome");
        } else {
            System.out.println("UC4 Result: " + arrayWord + " is not a Palindrome");
        }

        // UC5 – Stack Based Palindrome Check

        System.out.print("Enter a string for UC5 check: ");

        String stackWord = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < stackWord.length(); i++) {
            stack.push(stackWord.charAt(i));
        }

        String reversedStackWord = "";

        while (!stack.isEmpty()) {
            reversedStackWord = reversedStackWord + stack.pop();
        }

        if (stackWord.equals(reversedStackWord)) {
            System.out.println("UC5 Result: " + stackWord + " is a Palindrome");
        } else {
            System.out.println("UC5 Result: " + stackWord + " is not a Palindrome");
        }

        // UC6 – Queue + Stack Based Palindrome Check

        System.out.print("Enter a string for UC6 check: ");

        String qsWord = scanner.nextLine();

        Stack<Character> stackQS = new Stack<>();
        Queue<Character> queueQS = new LinkedList<>();

        for (int i = 0; i < qsWord.length(); i++) {
            stackQS.push(qsWord.charAt(i));       // LIFO
            queueQS.add(qsWord.charAt(i));        // FIFO
        }

        boolean isPalindromeQS = true;

        while (!stackQS.isEmpty()) {
            if (stackQS.pop() != queueQS.remove()) {
                isPalindromeQS = false;
                break;
            }
        }

        if (isPalindromeQS) {
            System.out.println("UC6 Result: " + qsWord + " is a Palindrome");
        } else {
            System.out.println("UC6 Result: " + qsWord + " is not a Palindrome");
        }

        // UC7 – Deque Based Optimized Palindrome Check

        System.out.println("-----------------------------------");
        System.out.print("Enter a string for UC7 check: ");

        String dequeWord = scanner.nextLine();

        Deque<Character> deque = new LinkedList<>();

        for (int i = 0; i < dequeWord.length(); i++) {
            deque.addLast(dequeWord.charAt(i));
        }

        boolean isPalindromeDeque = true;

        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindromeDeque = false;
                break;
            }
        }

        if (isPalindromeDeque) {
            System.out.println("UC7 Result: " + dequeWord + " is a Palindrome");
        } else {
            System.out.println("UC7 Result: " + dequeWord + " is not a Palindrome");
        }

// UC8 – Linked List Based Palindrome Check


        System.out.println("-----------------------------------");
        System.out.print("Enter a string for UC8 check: ");

        String llWord = scanner.nextLine();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < llWord.length(); i++) {
            Node newNode = new Node(llWord.charAt(i));

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        Node firstHalf = head;
        Node secondHalf = prev;

        boolean isPalindromeLL = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindromeLL = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        if (isPalindromeLL) {
            System.out.println("UC8 Result: " + llWord + " is a Palindrome");
        } else {
            System.out.println("UC8 Result: " + llWord + " is not a Palindrome");
        }

// UC9 – Recursive Palindrome Check


        System.out.println("-----------------------------------");
        System.out.print("Enter a string for UC9 check: ");

        String recursiveWord = scanner.nextLine();

        boolean isPalindromeRec = isPalindromeRecursive(
                recursiveWord,
                0,
                recursiveWord.length() - 1
        );

        if (isPalindromeRec) {
            System.out.println("UC9 Result: " + recursiveWord + " is a Palindrome");
        } else {
            System.out.println("UC9 Result: " + recursiveWord + " is not a Palindrome");
        }


    }

}
