package uebungen.blatt10.adam;

public class Knoten {

    Knoten vor;
    Knoten nach;

    Knoten() {

    }

    void platzierenNach(Knoten knoten) {

        if (this.nach == null) {
            knoten.nach = null;
            this.nach = knoten;
        } else {
            knoten.nach = this.nach;
            this.nach.vor = knoten;
            this.nach = knoten;
        }

        knoten.vor = this;

    }

}
