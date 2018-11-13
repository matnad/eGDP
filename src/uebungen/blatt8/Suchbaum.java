package uebungen.blatt8;

class Suchbaum {
    private Knoten wurzel;

    // Kein konstruktor. Baum kann leer sein.

    void einfuegen(int s, String w) {
        // linker und rechter baum erstellen falls er noch nicht existiert, dann die Bäume rekursiv aufbauen
        if (wurzel == null) {
            wurzel = new Blatt(s, w);
        } else if (wurzel instanceof Blatt) {
            if (s < wurzel.getSchluessel())
                wurzel = new InnereKnoten(wurzel.getSchluessel(), new InnereKnoten(s, new Blatt(s, w), new Blatt(wurzel.getSchluessel(), ((Blatt) wurzel).getWert())), null);
            else if (s > wurzel.getSchluessel())
                wurzel = new InnereKnoten(wurzel.getSchluessel(), wurzel, new Blatt(s, w));
            else
                System.out.println(String.format("Der Schlüssel %s existiert bereits.", s));
        } else if (((InnereKnoten) wurzel).getRechtesKind() == null && s > wurzel.getSchluessel()) {
            // nur linker Baum existiert
            ((InnereKnoten) wurzel).setRechtesKind(new Blatt(s, w));
        } else {
            // beide Bäume existieren (nur der rechte Baum alleine kann nie existieren)
            rekursivEinfuegen(s, w, (InnereKnoten) wurzel);
        }
    }

    private void rekursivEinfuegen(int s, String w, InnereKnoten position) {
        if (position.getLinkesKind() instanceof Blatt) {
            if (s < position.getLinkesKind().getSchluessel()) {
                position.setLinkesKind(new InnereKnoten(s, new Blatt(s, w), position.getLinkesKind()));
                return;
            } else if (s > position.getLinkesKind().getSchluessel() && s < position.getRechtesKind().getSchluessel()) {
                position.setLinkesKind(new InnereKnoten(position.getLinkesKind().getSchluessel(), position.getLinkesKind(), new Blatt(s, w)));
                return;
            } else if (s == position.getLinkesKind().getSchluessel()) {
                System.out.println(String.format("Der Schlüssel %s existiert bereits.", s));
                return;
            }
        }

        if (position.getRechtesKind() instanceof Blatt) {
            if (s > position.getRechtesKind().getSchluessel()) {
                position.setRechtesKind(new InnereKnoten(position.getRechtesKind().getSchluessel(), position.getRechtesKind(), new Blatt(s, w)));
                return;
            } else if (s == position.getRechtesKind().getSchluessel()) {
                System.out.println(String.format("Der Schlüssel %s existiert bereits.", s));
                return;
            }
        }

        if (s < position.getRechtesKind().getSchluessel()) {
            rekursivEinfuegen(s, w, (InnereKnoten) position.getLinkesKind());
        } else if (s > position.getRechtesKind().getSchluessel()) {
            rekursivEinfuegen(s,w, (InnereKnoten) position.getRechtesKind());
        } else {
            System.out.println(String.format("Der Schlüssel %s existiert bereits.", s));
        }
    }



    String suche(int s) {
        return rekursiveSuche(s, wurzel);
    }

    private String rekursiveSuche(int s, Knoten knoten) {

        if (knoten instanceof Blatt) {
            if(s == knoten.getSchluessel()) {
                return ((Blatt) knoten).getWert();
            } else {
                System.out.println("ERROR: Wert nicht gefunden.");
                return null;
            }
        } else if (knoten instanceof InnereKnoten) {
            if (s > knoten.getSchluessel()) {
                return rekursiveSuche(s, ((InnereKnoten) knoten).getRechtesKind());
            } else {
                return rekursiveSuche(s, ((InnereKnoten) knoten).getLinkesKind());
            }

        } else {
            System.out.println("ERROR: Wert nicht gefunden.");
            return null;
        }

    }

//    private Blatt findeBlatt(int s, Knoten position) {
////        if (s == position.getSchluessel() && position instanceof Blatt)
////            return (Blatt) position;
//        if (s <= position.getSchluessel() && position instanceof InnereKnoten) {
//            position = ((InnereKnoten) position).getLinkesKind();
//        } else if (s > position.getSchluessel() && position instanceof InnereKnoten) {
//            position = ((InnereKnoten) position).getRechtesKind();
//        } else {
//            return (Blatt) position;
//        }
//        return findeBlatt(s, position);
//    }



    public Knoten getWurzel() {
        return wurzel;
    }

    @Override
    public String toString() {
        return wurzel.toString();
    }

//    private String recursivePrint()
}
