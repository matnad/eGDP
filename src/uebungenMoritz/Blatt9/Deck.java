package uebungenMoritz.Blatt9;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    public static ArrayList<Karte> deck = new ArrayList<>();
    private String zeichen;
    private String zahl;
    private int anzahlKarten = 312;
    private int b;



    Deck() {
            for (int a = 0; a < 6; a++) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 1; j < 14; j++) {
                        switch (i) {
                            case 0:
                                zeichen = "♥";break;
                            case 1:
                                zeichen = "♦";break;
                            case 2:
                                zeichen = "♣";break;
                            case 3:
                                zeichen = "♠";break;
                        }
                        if (j>1 && j<11) {
                            deck.add(b,(new Karte(Integer.toString(j), zeichen,j)));

                        } else {
                            int wert = 0;
                            switch (j) {
                                case 1:
                                    zahl = "A";wert = 10;break;
                                case 11:
                                    zahl = "J";wert = 10;break;
                                case 12:
                                    zahl = "Q";wert = 10;break;
                                case 13:
                                    zahl = "K";wert = 10;break;
                            }
                            deck.add(b,(new Karte(zahl, zeichen,wert)));
                        }
                        b++;
                    }
                }
            }

    }

    public static Karte karteziehen1(){
        Random random = new Random() ;
        int x = (int) (Math.random()*(312))+0;
        //System.out.println(x);
        Karte ausgeben = new Karte(deck.get(x).zahl , deck.get(x).zeichen,deck.get(x).wert);
        deck.remove(x);
        return ausgeben;
    }
    /*public  String toString(){
        String out = null;
        for(int i = 0;i<305;i++){
            if(i%13 == 0){out += "\n";}
            out += deck.get(i).zahl + deck.get(i).zeichen + ",";
        }
        return out;

    }*/


}



