package uebungenMoritz.Blatt3;

public class BubbleSort {

    /**
     * Vertauscht zwei Werte in einem Array an den gegebenen Positionen.
     **/
    public static void swap(int i, int j, char[] characters) {
        /* Diese Methode muss implementiert werden */
        while(characters[i] > characters[j]){
            char b = characters[i];
            characters[i] = characters[j];
            characters[j] = b;
        }
    }

    /**
     * Sortiert das Eingabearray und aendert das Array in place
     **/
    public static void sort(char[] characters) {
        /* Diese Methode muss implementiert werden */
        for(int y = 0; y < characters.length; y++) {
            for (int i = 0, j = 1; j < characters.length; i++, j++) {
                swap(i, j, characters);

            }
        }
    }

    /**
     * Schreibt das Array auf die Ausgabekonsole
     **/
    public static void displayArray(char[] characters) {
        /* Diese Methode muss implementiert werden */
        for( int i = 0; i < characters.length; i++ )
            System.out.print(characters[i]);
    }

    /**
     * Die Hauptfunktion liest das Character Array und ruft die Sortierfunktion
     * und die Ausgabefunktion auf
     **/
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Bitte rufen Sie das Programm mit einem Eingabewert auf");
            System.out.println("  java BubbleSort 'dies ist ein text'");
            System.exit(-1);
        }
        char[] characters = args[0].toCharArray();

        sort(characters);

        displayArray(characters);
    }
}


