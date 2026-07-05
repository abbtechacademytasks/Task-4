import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        askingForCheckPalindrome();
        showPalindromeResult(checkEveryWordInSentenceForPalindrome(getUserInput()));
    }

    public static void askingForCheckPalindrome() {
        System.out.print("Enter the userInput for checking Palindrome: ");
    }

    public static void showPalindromeResult(boolean result) {
        System.out.println(
                result
                        ? "Entered userInput is Palindrome"
                        : "Entered userInput is not Palindrome or has no letters"
        );
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static boolean checkEveryWordInSentenceForPalindrome(String text) {
        if (removeSpecialSymbols(text).isEmpty()) {
            return false;
        }

        for (String word : getWordsFromSentence(text)) {
            if (!checkWordForPalindrome(word)) return false;
        }

        return true;
    }

    public static boolean checkWordForPalindrome(String word) {
        String cleaned = removeSpecialSymbols(word);
        String reversedText = reverseText(cleaned);

        return cleaned.equalsIgnoreCase(reversedText);
    }

    public static String[] getWordsFromSentence(String text) {
        String cleaned = text.replaceAll("[^\\p{L}\\s]", "");
        return cleaned.trim().split("\\s+");
    }

    public static String reverseText(String text) {
        char[] originalChars = text.toCharArray();
        char[] reversedChars = new char[originalChars.length];

        for (int i = 0; i < originalChars.length; i++) {
            reversedChars[i] = originalChars[originalChars.length - 1 - i];
        }

        return new String(reversedChars);
    }

    public static String removeSpecialSymbols(String text) {
        return text.replaceAll("[^\\p{L}]", "");
    }
}