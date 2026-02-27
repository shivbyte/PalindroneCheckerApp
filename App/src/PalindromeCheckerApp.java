import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;

public class PalindromeCheckerApp {

    // =========================
    // UC8 Node Class
    // =========================
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // =========================
    // UC9 Recursive Method
    // =========================
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    public static void main(String[] args){

        // UC1 – Welcome Message
        System.out.println("Welcome to Palindrome Checker App Management System");

        // =========================
        // UC2 – Hardcoded Palindrome
        // =========================
        String hardcodedWord = "madam";
        String reversedHardcoded = "";

        for (int i = hardcodedWord.length() - 1; i >= 0; i--) {
            reversedHardcoded += hardcodedWord.charAt(i);
        }

        System.out.println("UC2 Result: " + hardcodedWord +
                (hardcodedWord.equals(reversedHardcoded) ?
                        " is a Palindrome" : " is not a Palindrome"));

        Scanner scanner = new Scanner(System.in);

        // =========================
        // UC3 – Reverse Using Loop
        // =========================
        System.out.print("Enter a string for UC3 check: ");
        String userWord = scanner.nextLine();

        String reversedUserWord = "";
        for (int i = userWord.length() - 1; i >= 0; i--) {
            reversedUserWord += userWord.charAt(i);
        }

        System.out.println("UC3 Result: " + userWord +
                (userWord.equals(reversedUserWord) ?
                        " is a Palindrome" : " is not a Palindrome"));

        // =========================
        // UC4 – Character Array
        // =========================
        System.out.print("Enter a string for UC4 check: ");
        String arrayWord = scanner.nextLine();

        char[] characters = arrayWord.toCharArray();
        int start = 0, end = characters.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (characters[start] != characters[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("UC4 Result: " + arrayWord +
                (isPalindrome ? " is a Palindrome" : " is not a Palindrome"));

        // =========================
        // UC5 – Stack
        // =========================
        System.out.print("Enter a string for UC5 check: ");
        String stackWord = scanner.nextLine();

        Stack<Character> stack = new Stack<>();
        for (char c : stackWord.toCharArray()) {
            stack.push(c);
        }

        String reversedStackWord = "";
        while (!stack.isEmpty()) {
            reversedStackWord += stack.pop();
        }

        System.out.println("UC5 Result: " + stackWord +
                (stackWord.equals(reversedStackWord) ?
                        " is a Palindrome" : " is not a Palindrome"));

        // =========================
        // UC6 – Queue + Stack
        // =========================
        System.out.print("Enter a string for UC6 check: ");
        String qsWord = scanner.nextLine();

        Stack<Character> stackQS = new Stack<>();
        Queue<Character> queueQS = new LinkedList<>();

        for (char c : qsWord.toCharArray()) {
            stackQS.push(c);
            queueQS.add(c);
        }

        boolean isPalindromeQS = true;
        while (!stackQS.isEmpty()) {
            if (!stackQS.pop().equals(queueQS.remove())) {
                isPalindromeQS = false;
                break;
            }
        }

        System.out.println("UC6 Result: " + qsWord +
                (isPalindromeQS ? " is a Palindrome" : " is not a Palindrome"));

        // =========================
        // UC7 – Deque
        // =========================
        System.out.print("Enter a string for UC7 check: ");
        String dequeWord = scanner.nextLine();

        Deque<Character> deque = new LinkedList<>();
        for (char c : dequeWord.toCharArray()) {
            deque.addLast(c);
        }

        boolean isPalindromeDeque = true;
        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindromeDeque = false;
                break;
            }
        }

        System.out.println("UC7 Result: " + dequeWord +
                (isPalindromeDeque ? " is a Palindrome" : " is not a Palindrome"));

        // =========================
        // UC8 – Linked List
        // =========================
        System.out.print("Enter a string for UC8 check: ");
        String llWord = scanner.nextLine();

        Node head = null, tail = null;

        for (char c : llWord.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null, current = slow;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        Node firstHalf = head, secondHalf = prev;
        boolean isPalindromeLL = true;

        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindromeLL = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        System.out.println("UC8 Result: " + llWord +
                (isPalindromeLL ? " is a Palindrome" : " is not a Palindrome"));

        // =========================
        // UC9 – Recursion
        // =========================
        System.out.print("Enter a string for UC9 check: ");
        String recursiveWord = scanner.nextLine();

        boolean isPalindromeRec =
                isPalindromeRecursive(recursiveWord, 0, recursiveWord.length() - 1);

        System.out.println("UC9 Result: " + recursiveWord +
                (isPalindromeRec ? " is a Palindrome" : " is not a Palindrome"));

        // =========================
        // UC10 – Case Insensitive + Ignore Spaces
        // =========================
        System.out.print("Enter a string for UC10 check: ");
        String inputUC10 = scanner.nextLine();

        String normalized = inputUC10
                .replaceAll("\\s+", "")
                .toLowerCase();

        String reversedUC10 = "";
        for (int i = normalized.length() - 1; i >= 0; i--) {
            reversedUC10 += normalized.charAt(i);
        }

        System.out.println("UC10 Result: \"" + inputUC10 + "\"" +
                (normalized.equals(reversedUC10)
                        ? " is a Palindrome (Ignoring case & spaces)"
                        : " is NOT a Palindrome"));

        scanner.close();
        System.out.println("Program Ended Successfully.");
    }
}