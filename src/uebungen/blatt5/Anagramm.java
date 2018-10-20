package uebungen.blatt5;

public class Anagramm {

    public static void main(String args[]) {
        //String text = args[0];
        String text1 = "Dackel entlief Bassist -";
        String text2 = "Das laesst tief blicken.";
        boolean test = testAnagramm(text1, text2);
        System.out.println(test);
    }

    /**
     * Checks if two strings are an anagram. Ignores characters accoring to is_valid_char,
     * but will work for all unicode characters if is_valid_char allows.
     * @param text1 first string to check
     * @param text2 second string to check
     * @return true if the two strings are an anagram, false otherwise
     */
    public static boolean testAnagramm(String text1, String text2) {
        char[] t1 = text1.toLowerCase().toCharArray();
        char[] t2 = text2.toLowerCase().toCharArray();

        int[] count = new int[Character.MAX_VALUE];

        for (int i=0; i < t1.length; i++) {
            if (is_valid_char(t1[i]))
                count[t1[i]]++;
        }

        for (int i=0; i < t2.length; i++) {
            if (is_valid_char(t2[i]))
                count[t2[i]]--;
        }

        for (int c : count)
            if (c != 0)
                return false;

        return true;

    }

    /**
     * Determine if a char is to be considered when checking for anagrams. Currently a-z and äöü are valid.
     * @param c the char to check
     * @return true if the char is valid and to be considered, false if the char should be skipped
     */
    public static boolean is_valid_char(char c) {
        if (c >= 97 && (c <= 122 || c == 228 || c == 246 || c == 252))
            return true;
        else
            return false;
    }
}
