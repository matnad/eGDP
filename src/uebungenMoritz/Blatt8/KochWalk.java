package uebungenMoritz.Blatt8;

import ch.unibas.informatik.cs101.ImageWindow2;
import ch.unibas.informatik.cs101.Walker;

public class KochWalk {

    public  static void main (String[] args) {
        ImageWindow2 iw = new ImageWindow2(200, 100);
        Walker w = new Walker(iw);

        iw.openWindow("ImageWindow");
        w.setPos(30, 65);
        w.setColor(255, 0, 0);
        w.setDir(1, 0);
        w.pressBallPen();
        durchgang(w, 1);


        ImageWindow2 iw2 = new ImageWindow2(200, 200);
        Walker w2 = new Walker(iw2);

        iw2.openWindow("ImageWindow");
        w2.setPos(30, 100);
        w2.setColor(255, 0, 0);
        w2.setDir(1, 0);
        w2.pressBallPen();
        durchgang(w2, 2);

        ImageWindow2 iw3 = new ImageWindow2(500, 300);
        Walker w3 = new Walker(iw3);

        iw3.openWindow("ImageWindow");
        w3.setPos(30, 200);
        w3.setColor(255, 0, 0);
        w3.setDir(1, 0);
        w3.pressBallPen();
        durchgang(w3, 3);

        ImageWindow2 iw4 = new ImageWindow2(600, 600);
        Walker w4 = new Walker(iw4);

        iw4.openWindow("ImageWindow");
        w4.setPos(30, 200);
        w4.setColor(255, 0, 0);
        w4.setDir(1, 0);
        w4.pressBallPen();
        durchgang(w4, 3);
        w4.turn(120);
        durchgang(w4, 3);
        w4.turn(120);
        durchgang(w4, 3);








    }

        private static void durchgang(Walker w, int weg){
        if (weg == 0) {
            w.move(3.1415*5);
            return;
        }
        durchgang(w, weg-1);
        w.turn(-60);
        durchgang(w, weg-1);
        w.turn(2*60);
        durchgang(w, weg-1);
        w.turn(-60);
        durchgang(w, weg-1);

    }


    }

