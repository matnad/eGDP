package uebungen.blatt6;

class Artikel {

    private final String artikel;
    private final int menge;
    private final double preis;

    private final static int BREITE = Kassenbon.getBreite();

    Artikel(String artikel, int menge, double preis) {
        this.artikel = artikel;
        this.menge = menge;
        this.preis = preis;
    }

    double getPreis() {
        return preis;
    }

    int getMenge() {
        return menge;
    }

    @Override
    public String toString() {
        String totalStr = String.format("%"+ BREITE +"s%.2f","",menge*preis);

        StringBuilder out = new StringBuilder();
        out.append(String.format("%s%"+ BREITE /2+"s", artikel,""), 0, BREITE /2);
        out.append(String.format("%2d x", menge));
        out.append(String.format("  %.2f", preis));
        out.append("\n").append(totalStr, totalStr.length()- BREITE, totalStr.length());
        return out.toString();
    }



//    public static String centerString(String text){
//        String out = String.format("%"+BREITE+"s%s%"+BREITE+"s", "",text,"");
//        float mid = (out.length()/2);
//        float start = mid - (BREITE/2);
//        float end = start + BREITE;
//        return "|"+out.substring((int)start, (int)end)+"|";
//    }
}
