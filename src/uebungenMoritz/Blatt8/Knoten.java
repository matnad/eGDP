package uebungenMoritz.Blatt8;

public abstract class Knoten {
    public int schluessel;
    public int anzahlKnoten;

    Knoten(int a){
        schluessel = a;
    }

    public int getSchluessel() {
        return schluessel;
    }
}
