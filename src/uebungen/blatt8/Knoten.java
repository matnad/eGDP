package uebungen.blatt8;

public abstract class Knoten {
    private final int schluessel;

    Knoten(int s){
        schluessel = s;
    }

    public int getSchluessel() {
        return schluessel;
    }
}
