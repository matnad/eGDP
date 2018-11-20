package uebungenMoritz.Blatt8;

public class InnereKnoten extends Knoten {

    public Knoten linkeskind;
    public Knoten rechteskind;

    InnereKnoten(int a,Knoten linkeskind,Knoten rechteskind){
        super(a);
        this.linkeskind = linkeskind;
        this.rechteskind = rechteskind;

    }

    public Knoten getLinkeskind(){return linkeskind;}

    public Knoten getRechteskind(){return rechteskind;}
}
