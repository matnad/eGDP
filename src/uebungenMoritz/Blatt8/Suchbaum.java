package uebungenMoritz.Blatt8;



public class Suchbaum {
    private Knoten wurzel;

    void einfügen(int a, String place) {
        if (wurzel == null) {
            wurzel = new Blatt(a, place);
            wurzel.anzahlKnoten++;
        } else if (wurzel.anzahlKnoten > 0) {
            if (a < wurzel.getSchluessel()) {
                wurzel = new InnereKnoten(wurzel.getSchluessel(), new InnereKnoten(a, new Blatt(a, place), new Blatt(wurzel.getSchluessel(), ((Blatt) wurzel).getPlace())), null);
            } else {
                wurzel = new InnereKnoten(wurzel.getSchluessel(), wurzel, new Blatt(a, place));
            }


        }




/*void suche(){




}*/
    }
}
