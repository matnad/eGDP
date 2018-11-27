package uebungenMoritz.Blatt9;
import java.util.ArrayList;
public class Spieler {
    public ArrayList<Karte> karte = new ArrayList<>();
    private String name;
    private int anzahlkarten;


    Spieler(String name) {

        this.name = name;

    }

    public void karteziehen() {
        anzahlkarten++;
        this.karte.add(Deck.karteziehen1());
    }

    public void kartenlöschen() {
        for (int i = 0; anzahlkarten > 0; anzahlkarten--) {
            karte.remove(i);
        }
    }

    void print() {
        System.out.print(karte);
    }

    boolean überboten() {
        int kartenwert = 0;
        for (int i = 0; i < anzahlkarten; i++) {
            kartenwert += karte.get(i).wert;
        }
        if (kartenwert > 21) {
            for (int i = 0; i < anzahlkarten; i++) {
                if (karte.get(i).zahl == "A") {
                    karte.get(i).wert = 1;
                }
            }

            kartenwert = 0;
            for (int i = 0; i < anzahlkarten; i++) {
                kartenwert += karte.get(i).wert;
            }

            if (kartenwert > 21) {
                return false;
            } else {
                return true;
            }
        }else return true;

    }
        public int spielersumme () {
            int kartenwert = 0;
            for (int j = 0; j < anzahlkarten; j++) {
                kartenwert += karte.get(j).wert;
            }
            return kartenwert;
        }

}

