package uebungen.blatt6;

import static uebungen.blatt6.Kassenbon.centerString;

class Adresse {

    private final String titel;
    private final String name;
    private final String strasse;
    private final String hausnr;
    private final String plz;
    private final String ort;


    Adresse(String titel, String name, String strasse, String hausnr, String plz, String ort) {
        this.titel = titel;
        this.name = name;
        this.strasse = strasse;
        this.hausnr = hausnr;
        this.plz = plz;
        this.ort = ort;
    }

    @Override
    public String toString() {
        return centerString("=================================================================") +
                "\n" + centerString(titel) +
                "\n" + centerString(name) +
                "\n" + centerString(strasse + " " + hausnr) +
                "\n" + centerString(plz + " " + ort) +
                "\n" + centerString("=================================================================");
    }




}
