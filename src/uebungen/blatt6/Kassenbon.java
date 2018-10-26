package uebungen.blatt6;

import java.util.ArrayList;

class Kassenbon {

    private final ArrayList<Artikel> artikel = new ArrayList<>();
    private final Adresse adresse;

    private static final int BREITE = 35;

    Kassenbon(Adresse adresse) {
        this.adresse = adresse;
    }

    void add(Artikel artikel) {
        this.artikel.add(artikel);
    }

    private double getTotal() {
        double total = 0;
        for (Artikel a: artikel) {
            total += a.getPreis()*a.getMenge();
        }
        return total;
    }

    private String printTotal() {
        String totalPreis = String.format("%.2f", getTotal());
        return "--------------------------------------------------------------".substring(0, BREITE) +
                "\n" + String.format("%s%" + BREITE + "s", "Total", "").substring(0, BREITE - totalPreis.length()) +
                String.format("%s", totalPreis) +
                "\n" + "==============================================================".substring(0, BREITE);
    }

    void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        out.append(adresse);
        out.append("\n");
        for (Artikel a : artikel)
            out.append("\n").append(a);
        out.append("\n\n");
        out.append(printTotal());

        return out.toString();
    }

    static int getBreite() {
        return BREITE;
    }

    static String centerString(String text){
        int B = BREITE -2;
        String out = String.format("%"+B+"s%s%"+B+"s", "",text,"");
        float mid = (out.length()/2);
        float start = mid - (B/2);
        float end = start + B;
        return "|"+out.substring((int)start, (int)end)+"|";
    }

}
