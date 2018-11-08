package uebungenMoritz.Blatt6;
import java.util.ArrayList;

public class Kassenbon {
    static int b = 35;
    private final ArrayList<Artikel> artikel = new ArrayList<>();
    private final Adresse adresse;
    static int getBreite() {
        return b;
    }


    Kassenbon(Adresse adresse) {
        this.adresse = adresse;
    }

    void add(Artikel artikel) {
        this.artikel.add(artikel);
    }

    void print(){
        System.out.print(adresse);
        System.out.println();
        System.out.print(artikel);



    }

    static String mittig(String text){
        int B = b -2;
        String out = String.format("%"+B+"s%s%"+B+"s", "",text,"");
        float mid = (out.length()/2);
        float start = mid - (B/2);
        float end = start + B;
        return "|"+out.substring((int)start, (int)end)+"|";
    }
}
