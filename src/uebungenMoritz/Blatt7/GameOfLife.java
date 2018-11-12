package uebungenMoritz.Blatt7;
import java.util.Random;
public class GameOfLife {

    private boolean[][] feld;
    private int x;
    private int y;


    GameOfLife(){
        this.x = 6;
        this.y = 6;
        boolean[][] feldgg = {{false, false, false, false, false, false},
                {false, true, false, true, false, false},
                {false, false, true, true, false, false},
                {false, false, true, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false}};
        this.feld = feldgg;

    }

    GameOfLife(int x,int y) {
        this.x = x;
        this.y = y;
         boolean[][] feldrand = new boolean[x][y];
         for( int i = 0; i < x;i++){
             for(int j = 0;j < y;j++){
                 feldrand[i][j] = zelle();
             }
         }
         this.feld = feldrand;
    }

    static boolean zelle() {
        Random rn = new Random();
        int i = rn.nextInt(10);
        if (i < 3) {
            return true;
        }
        return false;
    }
    void print() { System.out.println(this); }


    public String toString(){
        StringBuilder a = new StringBuilder();

        a.append(text(feld));
        a.append("\n");
        a.append(text(tauschen(feld)));
      return  a.toString();
    }

     String text (boolean[][] ende) {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (ende[i][j]) {
                    out.append("@");
                } else {
                    out.append(".");
                }
            }
            out.append("\n");
        }
        return out.toString();
    }



    private boolean[][] tauschen(boolean[][] feld) {
        boolean [][] feld2 = new boolean[x][y];
        int z;
        int f;
        int g;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                z = 0;
                for (int a = i - 1; a <= i + 1; a++) {
                    for (int b = j - 1; b <= j + 1; b++) {
                        f = a;
                        g = b;
                        if (f<0)f = x-1;
                        if (g<0)g = y-1;
                        if (feld[f % x][g % y]) {
                            z++;
                        }
                    }
                }

                if (feld[i][j]) {
                    z--;
                    if (2 <= z && z <= 3) { feld2[i][j] = true; }
                    else { feld2[i][j] = false; }

                }
                else{
                    if (z != 3) { feld2[i][j] = false; }
                    else{feld2[i][j] = true;}
                }

            }
        }
        return feld2;
    }
}

