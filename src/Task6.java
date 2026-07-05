import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        askingEnteringTextForGettingLettersCount();
        showResult(getRepeatedLettersFromWords(getUserInput())); // Case sensitive saxladım çünki taskda qeyd edilməyib
    }

    public static List<List<String>> getRepeatedLettersFromWords (String text) {
        char[] formattedLetters = removeSpecialSymbols(text).toCharArray();
        List<List<String>> resultList = new ArrayList<>();

        for (char formattedLetter : formattedLetters) {
            String letter = String.valueOf(formattedLetter);
            if (!isLetterContainsInList(resultList, letter)) {
                List<String> tempResultList = new ArrayList<>();
                tempResultList.add(letter);
                tempResultList.add("1");
                resultList.add(tempResultList);
            } else {
                int indexOfList = getIndexOfLetterContainsInList(resultList, letter);

                if (indexOfList == -1)
                    continue;

                int number = Integer.parseInt(resultList.get(indexOfList).get(1));
                number++;
                resultList.get(indexOfList).set(1, String.valueOf(number));
            }
        }

        return resultList;
    }

    public static boolean isLetterContainsInList(List<List<String>> checkedList, String checkedLetter) {
        for (List<String> strings : checkedList) {
            if (!strings.isEmpty() && strings.getFirst().equals(checkedLetter)) {
                return true;
            }
        }

        return false;
    }

    public static int getIndexOfLetterContainsInList(List<List<String>> checkedList, String checkedLetter) {
        for (int i = 0; i < checkedList.size(); i++) {
            if (checkedList.get(i).getFirst().equals(checkedLetter)) {
                return i;
            }
        }

        return -1;
    }

    public static void askingEnteringTextForGettingLettersCount() {
        System.out.print("Enter the text for getting letters count: ");
    }

    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void showResult(List<List<String>> results) {
        for (List<String> result : results) {
            System.out.println(result.getFirst() + " - " + result.get(1));
        }
    }

    public static String removeSpecialSymbols(String text) {
        return text.replaceAll("[^\\p{L}]", "");
    }
}