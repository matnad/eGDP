package uebungenMoritz.Blatt5;



@SuppressWarnings("Duplicates")
public class Palindrom {

    public static void main (String []args) {
        boolean b = testPalindrom(args[0]);
        if (b)System.out.print("[" + args[0] + "]" + " ist ein Palindrom.");
        else  System.out.print("[" + args[0] + "]" + " ist kein ein Palindrom.");



    }
    private static boolean testPalindrom(String text){
        char[] characters = text.toCharArray();
        char[] new_characters = new char[characters.length];
        boolean a = true;
        int j = 0;
        int sonderzeichenzeichen = 0;
        for(int i = 0; i < characters.length;i++){
            characters[i] = Character.toLowerCase(characters[i]);

            if((96 < characters[i] && characters[i] < 123 )|| characters[i] == 228 || characters[i] == 246 || characters[i] == 252){
                new_characters[j] = characters[i];
                j++;
            }
            else{sonderzeichenzeichen++;}
        }
        for(int i = 0;i < new_characters.length/2;i++){
            if(new_characters[i] != new_characters[new_characters.length-sonderzeichenzeichen-1-i]){

                a = false;
                return a;
            }
        }
        return a;
    }
}
