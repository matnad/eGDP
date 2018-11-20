package uebungenMoritz.Blatt8;

public abstract class Knoten {
    public int schluessel;
    public int anzahlKnoten;

    Knoten(int s){
        schluessel = s;
    }

    public int getSchluessel() {
        return schluessel;
    }
}
