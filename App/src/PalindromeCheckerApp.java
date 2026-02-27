import java.util.Scanner;

public class PalindromeCheckerApp {
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
    }

}
