package uebungenMoritz.Blatt9;

public class Karte{
     int wert;
     String zahl;
     String zeichen;


    Karte(String zahl,String zeichen,int wert){

        this.zahl = zahl;
        this.zeichen = zeichen;
        this.wert = wert;
    }


    public String toString() {
        return zahl + zeichen;
    }
}
