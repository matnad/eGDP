package uebungen.blatt10;

/**
 * Fehler 1: Namespace in Konstructor: braucht this
 * Fehler 2: toString() braucht return statement: return hinzufügen
 * Fehler 3: Klasse ist nicht ausführbar, da keine main methode: testAccount() -> main(...)
 * Fehler 4: accounts[0] = new Account(...) geht nicht, da accounts nicht initialisiert ist: ... = new Account[2];
 * Fehler 5: i in der for schleife ist nicht initialisiert: int i; ...
 * Fehler 6: for schleife führt zu index out of bounds, da sie versucht über 3 elemente zu iterieren: ...; i < accounts.length; ...
 * Anmerkung1: Formatierung für geldbeträge sollte .2f sein.
 * Anmerkung2: For each loop wäre schöner als for loop, um Fehler wie Fehler 6 zu vermeiden.
 */


public class Account {
    private double value;
    private String name;

    Account(String name, double value) {
        this.name = name;
        this.value = value;
    }

    public String toString() {
        return "Account: " + name + " contains " + value + "chf";
    }

    public static void main(String[] args) {
        Account accounts[] = new Account[2];
        accounts[0] = new Account("Petra", 111);
        accounts[1] = new Account("Klaus", 999);
        for (int i=0; i < accounts.length; ++i)
            System.out.println(accounts[i]);
    }
}