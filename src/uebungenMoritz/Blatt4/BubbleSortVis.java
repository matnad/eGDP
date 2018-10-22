package uebungenMoritz.Blatt4;

import ch.unibas.informatik.cs101.ImageWindow;



class BubbleSortVis {

    private static ImageWindow w;
    private static int orange_max = 0;


    /**
     * Vertauscht zwei Werte in einem Array an den gegebenen Positionen.
     **/
    private static void swap(int i, int j, char[] characters) {
        /* DONE: Diese Methode muss implementiert werden */
        char temp = characters[i];
        characters[i] = characters[j];
        characters[j] = temp;

    }

    /**
     * Sortiert das Eingabearray und aendert das Array in place
     **/
    private static void sort(char[] characters, ImageWindow w) {
        /*
         * DONE: Diese Methode muss implementiert werden
         * DONE: Ist "A" oder "a" grösser? -> Direkter vergleich ohne methoden/funktionen
         */
        boolean done = false;

        while (!done) {
            done = true;
            for (int i = 0; i < characters.length - 1; i++) {
                if (characters[i + 1] < characters[i]) {
                    swap(i, i + 1, characters);
                    done = false;
                    show(characters, w);


                }



            }
        }
    }


    /**
     * Schreibt das Array auf die Ausgabekonsole
     **/
    private static void displayArray(char[] characters) {
        /* DONE: Diese Methode muss implementiert werden */
        System.out.println(characters);
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

        w = new ImageWindow(500,500);
        w.openWindow();
        char[] characters = args[0].toCharArray();
        for(int i = 0;i < characters.length;i++){
            if(orange_max < characters[i] ){
                orange_max = characters[i];
            }

        }

        show(characters,w);
        sort(characters, w);




        displayArray(characters);
    }

       private static void show(char[] characters,ImageWindow w) {


        int breite;
        breite = 500 / characters.length;
        int i = 0;
        for (int x = 0; x < 500; x++) {


           if (x > breite * (i+1)) {
               i++;
           }

               int red = 0;
               int green = 0;
               int blue = 255;
               red = red + (characters[i] * 255 / orange_max);
               green = green + (characters[i] * 100  / orange_max);
               blue = blue - (characters[i] * 255 / orange_max);


               for (int y = 500 - (characters[i] * 3); y < 500; y++) {
                   w.setPixel(x, y, red, green, blue);
               }

        }

        w.redraw();
        w.pause(10);

    }

}

