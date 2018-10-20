package uebungen.blatt5;


public class Palindrom {

    public static void main(String args[]) {
        //String text = args[0];
        String text = "Eine güldne, gute Tugend: Lüge nie!";
        boolean test = testPalindrome(text);
        System.out.println(test);
    }

    /**
     * Check if the input text is a palindrome (the same read backwards and forwards).
     * Ignore every character that is not a-z or äöü
     * @param text input string to test
     * @return boolean true if the text is a palindrome, false otherwise
     */
    public static boolean testPalindrome(String text){
        text = text.toLowerCase();
        char[] t = text.toCharArray();

        int i = 0; int j = t.length-1;
        while (i <= j) {

            if (is_invalid_char(t[i])) {
                i++; continue; }

            if (is_invalid_char(t[j])) {
                j--; continue; }

            if (t[i] == t[j]) {
                i++; j--;
            } else {
                return false;
            }
        }
        return true;
    }


    /**
     * Check if a char is to be considered when checking if the string is a palindrome
     * @param c the char to check
     * @return true if the char is valid and to be considered, false if the char should be skipped
     */
    public static boolean is_invalid_char(char c) {
        return c < 97 || (c > 122 && c != 228 && c != 246 && c != 252);
    }
//    public static boolean testPalindrome(String text){
//
//        text = text.toLowerCase();
//        char[] t = text.toCharArray();
//
//        /*
//         * Build new char array with only letters a-z äöü
//         * We use LinkedList because we don't know the final size of the array
//         * and we don't want to resize the array every iteration.
//         */
//        LinkedList<Character> t2 = new LinkedList();
//        for(int i=0; i < t.length; i++) {
//            if (t[i] >= 97 && (t[i] <= 122 || t[i] == 228 || t[i] == 246 || t[i] == 252)) {
//                t2.add(t[i]);
//            }
//        }
//        Character[] t3 = t2.toArray(new Character[t2.size()]);
//
//        /*
//         * Test for palindrome and return false as soon as the rules are broken
//         * (int) required for unicode characters (here: äöü)
//         */
//        for (int i=0, j=t3.length-1; i <= j; i++, j--){
//            if ((int) t3[i] != (int) t3[j])
//                return false;
//        }
//
//        // Return true if no errors
//        return true;
//    }
}
