package uebungen.blatt10;

public class FindChar {

    /**
     * Fehler 1: i ist nicht mehr gültig nach der for schleife
     * Fehler 2: Wenn nicht gefunden, wird nicht -1 zurückgegeben
     * Lösung: return variable auf -1 initialisieren und wenn gefunden mit der position updaten.
     */

    public static int findChar(String s, char c) {
        int found = -1;
        for (int i=0; i<s.length(); ++i)
            if (s.charAt(i) == c) {
                found = i; break;
            }
        return found;
    }

    public static void main(String[] args) {
        System.out.println(findChar("test", 's'));
    }
}
