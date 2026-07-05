public class Task5 {
    public static void main(String[] args) {
        showResult(runLengthEncode("aaabbc"));
        showResult(runLengthDecode("a3b2c1"));
        showResult(runLengthDecode("a20b2c1"));
    }

    public static void showResult(String result) {
        System.out.println("\"" + result + "\"");
    }

    public static String runLengthEncode(String word) {
        if (word.isBlank()) return "";

        StringBuilder encodedText = new StringBuilder();
        char lastLetter = word.charAt(0);
        int letterCount = 0;

        for (int i = 0; i < word.length(); i++) {
            char foundLetter = word.charAt(i);
            if (lastLetter != foundLetter) {
                encodedText.append(lastLetter);
                encodedText.append(letterCount);
                lastLetter = foundLetter;
                letterCount = 0;
            }

            letterCount++;
        }

        encodedText.append(lastLetter);
        encodedText.append(letterCount);

        return encodedText.toString();
    }

    public static String runLengthDecode(String word) {
        if (word.isEmpty()) return "";

        StringBuilder decodedText = new StringBuilder();
        char lastFoundedLetter = word.charAt(0);
        StringBuilder lastFoundedNumberText = new StringBuilder();

        for (int i = 1; i < word.length(); i++) {
            char foundLetter = word.charAt(i);

            if (Character.isDigit(foundLetter)) {
                lastFoundedNumberText.append(foundLetter);

                if (i == word.length() - 1)
                    decodedText.append(createWordFromRepeatedLetters(lastFoundedLetter, lastFoundedNumberText));
            } else {
                decodedText.append(createWordFromRepeatedLetters(lastFoundedLetter, lastFoundedNumberText));
                lastFoundedLetter = foundLetter;
                lastFoundedNumberText = new StringBuilder();
            }
        }

        return decodedText.toString();
    }

    public static String createWordFromRepeatedLetters(char letter, StringBuilder repeatedTime) {
        if (repeatedTime.isEmpty())
            return "";

        return String.valueOf(letter).repeat(Integer.parseInt(repeatedTime.toString()));
    }
}