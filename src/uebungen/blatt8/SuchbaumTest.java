package uebungen.blatt8;

public class SuchbaumTest {
    public static void main(String[] args) {
        Suchbaum sb = new Suchbaum();
        sb.einfuegen(3920, "Zermatt");
        sb.einfuegen(3215, "Gempenach");
        sb.einfuegen(4000, "Basel");
        sb.einfuegen(4312, "Magden");
        sb.einfuegen(7436, "Medels");
        sb.einfuegen(3800, "Interlaken");

        int suche = 4312;
        System.out.println(String.format("Suche für %d:", suche ));
        System.out.println(sb.suche(suche));

        System.out.println();
        System.out.println(sb);


    }
}
