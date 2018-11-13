package uebungen.blatt8;

class InnereKnoten extends Knoten{
    private Knoten linkesKind;
    private Knoten rechtesKind;

    InnereKnoten(int s, Knoten linkesKind, Knoten rechtesKind) {
        super(s);
        this.linkesKind = linkesKind;
        this.rechtesKind = rechtesKind;
    }

    Knoten getLinkesKind() {
        return linkesKind;
    }

    Knoten getRechtesKind() {
        return rechtesKind;
    }

    void setLinkesKind(Knoten linkesKind) {
        this.linkesKind = linkesKind;
    }

    void setRechtesKind(Knoten rechtesKind) {
        this.rechtesKind = rechtesKind;
    }

    @Override
    public String toString() {
        StringBuilder out = rekursivStringbuilder();
        return out.toString();
    }

    private StringBuilder rekursivStringbuilder(StringBuilder sb, String prefix, InnereKnoten knoten) {

        // print current node
        sb.append(knoten.getSchluessel()).append(System.lineSeparator());

        // first to the left nodes
        sb.append(prefix).append("├──");
        if (knoten.getLinkesKind() instanceof Blatt)
            sb.append(knoten.getLinkesKind().toString()).append(System.lineSeparator());
        else
            rekursivStringbuilder(sb, prefix+"|    ", (InnereKnoten) knoten.getLinkesKind());

        // then the right nodes
        sb.append(prefix).append("└──");
        if (knoten.getRechtesKind() instanceof Blatt)
            sb.append(knoten.getRechtesKind().toString()).append(System.lineSeparator());
        else
            rekursivStringbuilder(sb, prefix+"    ", (InnereKnoten) knoten.getRechtesKind());


        return sb;
    }

    private StringBuilder rekursivStringbuilder() {
        StringBuilder out = new StringBuilder();
        String prefix = "";
        return rekursivStringbuilder(out, prefix, this);
    }


}
