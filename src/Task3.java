public class Task3 {
    public static void main(String[] args) {
        String[] firstWords = {"telefon", "televizor", "teleskop"};
        showResult(firstWords);

        String[] secondWords = {"it", "pişik"};
        showResult(secondWords);
    }

    public static void showResult(String[] words) {
        System.out.println("\"" + checkPrefix(words) + "\"");
    }

    public static String checkPrefix(String[] words) {
        String result = "";

        if (words.length == 0 || words[0].isBlank()) return result;

        for (int i = 1; i <= words[0].length(); i++) {
            String prefix = words[0].toLowerCase().substring(0, i);

            for (String word : words) {
                if (!word.toLowerCase().startsWith(prefix)) {
                    return result;
                }
            }

            result = words[0].substring(0, i);
        }

        return result;
    }
}