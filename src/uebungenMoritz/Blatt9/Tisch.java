package uebungenMoritz.Blatt9;


import java.util.Scanner;

public class Tisch {
    public static void main(String[] args) {

        Deck deck = new Deck();
        Spieler dealer = new Spieler("Dealer");
        System.out.println("Willkommen an diesem Black Jach Tisch." + "\n" + "Geben Sie bitte Ihren Username ein.");

        String username = name();

        Spieler spieler1 = new Spieler(username);
        System.out.println(String.format("Willkommen %s. Wie gross soll Ihr Einsatz sein?", username));


        int kontostand = betrag();

        System.out.println(String.format("Ihr Kontostand beträgt nun %dCHF", kontostand));

        boolean amtisch = true;
        while (amtisch) {
            boolean frage = true;
            System.out.println("Welchen Betrag möchten Sie setzen?");

            int einsatz = betrag();
            System.out.println(String.format("Ihr Einsatz ist %d", einsatz));

            System.out.println("Dealer");
            dealer.karteziehen();
            dealer.print();
            System.out.println();
            System.out.println();

            System.out.println(username);
            spieler1.karteziehen();
            spieler1.karteziehen();
            spieler1.print();
            System.out.println();

            boolean ziehen = true;

            do{


                if (spieler1.spielersumme() == 21) {
                    System.out.print("Black Jack!!!");
                    ziehen = false;
                    kontostand += einsatz;
                    System.out.println(String.format("Ihr Kontostand beträgt neu %d", kontostand));
                }

                System.out.print("Ziehen Sie noch eine weitere Karte? Ja oder Nein\n");

                String antwort = jaodernein();
                if (antwort.equals("Ja")) {
                    spieler1.karteziehen();
                    spieler1.print();

                    if (!spieler1.überboten()) {
                        System.out.println("Tut mir leid. Sie haben sich überkauft");
                        ziehen = false;
                        kontostand -= einsatz;
                        System.out.println(String.format("Ihr Kontostand beträgt neu %d", kontostand));

                        ziehen = false;
                    }
                } else if (antwort.equals("Nein")) {

                    ziehen = false;

                    System.out.println("Dealer");
                    while (spieler1.spielersumme() > dealer.spielersumme() && dealer.spielersumme() < 17) {
                        dealer.karteziehen();
                        dealer.print();
                        System.out.println();
                    }
                    if (dealer.spielersumme() > 21) {
                        System.out.println("Glückwunsch!!! Sie haben gewonnen");
                        ziehen = false;
                        kontostand += einsatz;
                        System.out.println(String.format("Ihr Kontostand beträgt neu %d", kontostand));
                    } else if (dealer.spielersumme() > spieler1.spielersumme()) {
                        System.out.println("Tut mir leid. Der Dealer hat gewonnen.");
                        ziehen = false;
                        kontostand -= einsatz;
                        System.out.println(String.format("Ihr Kontostand beträgt neu %d", kontostand));
                    } else {
                        System.out.println("Glückwunsch!!! Sie haben gewonnen");
                        ziehen = false;
                        kontostand += einsatz;
                        System.out.println(String.format("Ihr Kontostand beträgt neu %d", kontostand));

                    }


                } else {
                    System.out.print("Ungültige Antwort");

                }


                if (kontostand == 0) {
                    System.out.println("Wollen Sie erneut Geld einzahlen? Ja oder Nein");
                    antwort = jaodernein();
                    if (antwort.equals("Ja")) {
                        System.out.println("Welchen Betrag wollen Sie einzahlen?");
                        kontostand = betrag();
                        ziehen = false;
                        frage = false;

                    } else {
                        System.out.println("Ich wünsche Ihnen noch einen Schönen Tag.");
                        amtisch = false;
                        frage = false;

                    }
                }
            }while (ziehen);

            spieler1.kartenlöschen();
            dealer.kartenlöschen();


            if (frage){System.out.println("Wollen Sie eine weitere Runde spielen?");
             String bleiben = jaodernein();
            if(bleiben.equals("Nein")) {
                amtisch = false;
                System.out.println("Ich wünsche Ihnen noch einen schönen Tag.");
            }}
        }
    }

        private static int betrag() {
            Scanner scanner = new Scanner(System.in);
            int betrag = scanner.nextInt();
            return betrag;

        }

        private static String jaodernein(){
            Scanner scanner = new Scanner(System.in);
            String antwort = scanner.nextLine();
            if (antwort.equals("Ja")) {
                return "Ja";
            } else{
                return "Nein";
            }

        }
        private static String name() {
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            return name;
        }

}

