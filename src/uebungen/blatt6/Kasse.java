package uebungen.blatt6;

public class Kasse {
    public static void main(String[] args) {
        Kassenbon b = new Kassenbon( new Adresse("Herbstmesse Basel", "Uni Basel", "Petersplatz", "1", "4001", "Basel"));
        b.add( new Artikel("Marroni",2,5.40));
        b.add( new Artikel("Magebrot",5,1.10));
        b.add( new Artikel("Glühwein",2,6));
        b.print();

        System.out.println();
        System.out.println();

        Kassenbon c = new Kassenbon( new Adresse("MUBA", "Universität Basel", "Messeplatz", "1", "4444", "Basel"));
        c.add( new Artikel("Schallplatte",12,2.40));
        c.add( new Artikel("Bratwurst",1,5.10));
        c.add( new Artikel("Feldschlösschen Dose 0.5L",2,8.50));
        c.add( new Artikel("Butterbretzel",3,5.50));
        c.print();
    }

}