import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        String[] words = {"ət", "tə", "kiş", "şik", "ana"};

        System.out.println(getAnagram(words));
    }

    public static List<List<String>> getAnagram(String[] words) {
        List<List<String>> result = new ArrayList<>();
        boolean[] used = new boolean[words.length];

        for (int i = 0; i < words.length; i++) {
            if (used[i] || words[i].isBlank()) {
                continue;
            }

            List<String> tempResult = new ArrayList<>();
            tempResult.add(words[i]);
            used[i] = true;

            for (int k = i + 1; k < words.length; k++) {
                if (!used[k]
                        // short-circuit evaluation tətbiqi əgər eyni deyilsə uzunluq yalandan kod icra edilmir
                        && words[i].length() == words[k].length()
                        && isAnagram(words[i], words[k])) {
                    tempResult.add(words[k]);
                    used[k] = true;
                }
            }
            result.add(tempResult);
        }

        return result;
    }

    public static boolean isAnagram(String firstText, String secondText) {
        return sortLettersInText(firstText).equalsIgnoreCase(sortLettersInText(secondText));
    }

    public static String sortLettersInText(String text) {
        char[] letters = text.toLowerCase().toCharArray();
        Arrays.sort(letters);

        return new String(letters);
    }
}