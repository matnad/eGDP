package uebungenMoritz.Blatt5;

@SuppressWarnings("Duplicates")
public class Anagramm {
    public static void main(String[] args) {
        boolean b = testAnagramm(args[0], args[1]);
        System.out.print(b);
    }


    private static boolean testAnagramm(String text1, String text2) {
        char[] char1 = text1.toCharArray();
        char[] char2 = text2.toCharArray();

        boolean a = true;

        char[] char1_2 = ohneS(char1);
        char[] char2_2 = ohneS(char2);

        int[] all_Symbol = new int[255];
        for (int i : char1_2) {
            all_Symbol[i]++;
        }

        for (int i : char2_2) {
            all_Symbol[i]--;
        }

        for(int i = 0; i < all_Symbol.length;i++){
           if( all_Symbol[i] != 0){
               a = false;
               return  a;
           }
        }
        return a;
    }
        private static char[] ohneS(char[] characters) {
            char[] new_characters = new char[characters.length];
            int j = 0;
            int sonderzeichen = 0;
            for(int i = 0; i < characters.length;i++){
                characters[i] = Character.toLowerCase(characters[i]);

                if ((96 < characters[i] && characters[i] < 123) || characters[i] == 228 || characters[i] == 246 || characters[i] == 252) {
                    new_characters[j] = characters[i];
                    j++;
                } else {
                    sonderzeichen++;

                }
            }
            char[] end_characters = new char[j];

            for (int i = 0; i < end_characters.length; i++) {
                end_characters[i] = new_characters[i];
            }
            return end_characters;
    }
}
