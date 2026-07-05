import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        String[] words = {"kitab", "kitabxana", "kino", "kompüter"};

        askingEnteringPrefixForAutoComplete();
        showResult(wordAutoCompleter(words, getUserInput()));
    }

    public static List<String> wordAutoCompleter(String[] words, String prefix) {
        List<String> resultList = new ArrayList<>();

        for (String word : words) {
            if (word.toLowerCase().startsWith(prefix.toLowerCase()))
                resultList.add(word);
        }

        return resultList;
    }

    public static void askingEnteringPrefixForAutoComplete() {
        System.out.print("Enter the prefix for getting best matches: ");
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void showResult(List<String> results) {
        System.out.println(results);
    }
}