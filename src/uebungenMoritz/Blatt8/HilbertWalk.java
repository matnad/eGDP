package uebungenMoritz.Blatt8;

import ch.unibas.informatik.cs101.ImageWindow2;
import ch.unibas.informatik.cs101.Walker;

public class HilbertWalk {
    public static void main (String[] args){

        ImageWindow2 iw = new ImageWindow2(200, 200);
        Walker w = new Walker(iw);
        iw.openWindow("ImageWindow", 220, 0);
        w.setPos(180, 180);
        w.setColor(0, 0, 0);
        w.setDir(-1, 0);
        w.pressBallPen();
        macher(w,1);

        ImageWindow2 iw2 = new ImageWindow2(200, 200);
        Walker w2 = new Walker(iw2);
        iw2.openWindow("ImageWindow", 220, 0);
        w2.setPos(180, 180);
        w2.setColor(0, 0, 0);
        w2.setDir(-1, 0);
        w2.pressBallPen();
        macher(w2,2);

        ImageWindow2 iw3 = new ImageWindow2(200, 200);
        Walker w3 = new Walker(iw3);
        iw3.openWindow("ImageWindow", 220, 0);
        w3.setPos(180, 180);
        w3.setColor(0, 0, 0);
        w3.setDir(-1, 0);
        w3.pressBallPen();
        macher(w3,3);

    }

     static void macher(Walker w, int depth) {
        if (depth == 0) return;
        w.turn(90);
        macher2(w, depth-1);
        w.move(10);
        w.turn(-90);
        macher(w, depth-1);
        w.move(10);
        macher(w, depth-1);
        w.turn(-90);
        w.move(10);
        macher2(w,depth-1);
        w.turn(90);
    }
     static void macher2(Walker w, int depth) {
        if (depth == 0) return;
        w.turn(-90);
        macher(w, depth-1);
        w.move(10);
        w.turn(90);
        macher2(w, depth-1);
        w.move(10);
        macher2(w, depth-1);
        w.turn(90);
        w.move(10);
        macher(w, depth-1);
        w.turn(-90);
    }
}
