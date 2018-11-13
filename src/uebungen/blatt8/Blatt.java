package uebungen.blatt8;

class Blatt extends Knoten{
    private final String wert;

    Blatt(int s, String w) {
        super(s);
        wert = w;
    }

    public String getWert() {
        return wert;
    }

    @Override
    public String toString() {
        return String.format("<%d, %s>", getSchluessel(), getWert());
    }
}
