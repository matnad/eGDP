package uebungenMoritz.Blatt7;

public class BasicGOL {
    public static void main(String[] args){
        GameOfLife a = new GameOfLife();
        GameOfLife b = new GameOfLife(7,7);
        a.print();
        b.print();
    }
}
