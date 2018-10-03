package uebungen.blatt1;

public class HalloWelt {
    public static void main(String args[]) {
        System.out.println("Hallo Welt");
    }
}

/**
 * a) Error:(3, 8) java: class HaloWelt is public, should be declared in a file named HaloWelt.java
 *    Bedeutet: Name der Klasse muss gleich Name des Files ohne Endung sein.
 * b.1) public: Error: Main method not found in class uebungen.blatt1.HalloWelt, please define the main method as:
 *    public static void main(String[] args)
 *    or a JavaFX application class must extend javafx.application.Application
 * b.2) Error: Main method is not static in class uebungen.blatt1.HalloWelt, please define the main method as:
 *    public static void main(String[] args)
 * b.3) Void: Error:(4, 19) java: invalid method declaration; return type required
 * b.4) Bedeutet: Main methode muss genau so definiert sein, muss static sein und es muss ein return type angegeben werden.
 *      return "void" heisst kein return.
 * c) p s v: Standard Reihenfolge. Kompiliert.
 *    p v s:  Error:(4, 24) java: invalid method declaration; return type required. Return type scheint das letzte argument
 *            sein zu müssen vor dem namen der methode.
 *    s p v: Kompiliert
 *    s v p: Siehe p v s.
 *    v p s: Siehe p v s.
 *    v s p: Siehe p v s.
 * d.1) Error:(4, 29) java: illegal start of type. Kein Variablentyp startet mit eckicken Klammern.
 * d.2) Normale Variante, kompiliert. String wird korrekt als Array definiert.
 * d.3) Kompiliert. Scheint eine alternative definition für ein String array zu sein.
 * d.4) Kompiliert. Scheint eine alternative definition für ein String array zu sein.
 *      In Fällen 2, 3, 4 erhalte ich immer ein String Array "args" mit den Konsolenparametern.
 */