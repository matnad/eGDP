package uebungenMoritz.Blatt6;

import static uebungenMoritz.Blatt6.Kassenbon.mittig;

class Adresse{


        static String first;
        static String second;
        static String third;
        static String fourth;

        Adresse(String first, String second, String third, String third2, String fourth, String fourth2) {
            this.first = first;
            this.second = second;
            this.third = third + " " + third2;
            this.fourth = fourth + " " + fourth2;


        }



    public String toString() {
        return "|==========================|" +
                "\n" +  mittig(first) +
                "\n" + mittig(second) +
                "\n" + mittig(third)  +
                "\n" + mittig(fourth) +
                "\n" + "|==========================|";
        }
}

