import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        askingForInput();
        showLongestTextWithoutRepeatedLetters();
    }

    public static void askingForInput() {
        System.out.print("Enter the text: ");
    }

    public static void showLongestTextWithoutRepeatedLetters() {
        String text = getLongestTextWithoutRepeatedLetters(getUserInput());

        System.out.println(text.length() + " \"(" + text + ")\"");
    }

    public static String getLongestTextWithoutRepeatedLetters(String text) {
        String longestText = "";

        for (int k = 0; k < text.length(); k++) {
            StringBuilder foundText = new StringBuilder();

            for (int i = k; i < text.length(); i++) {
                char letter = text.charAt(i);
                if (foundText.indexOf(String.valueOf(letter)) != -1) {
                    break;
                }

                foundText.append(letter);
            }

            if (foundText.length() > longestText.length()) {
                longestText = foundText.toString();
            }
        }

        return longestText;
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}