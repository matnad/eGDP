package uebungen.blatt8;

import ch.unibas.informatik.cs101.ImageWindow2;
import ch.unibas.informatik.cs101.Walker;

public class HilbertWalk {
    private final static int distance = 22;
    public static void main(String[] args) {
        // Image 1
        ImageWindow2 iw1 = new ImageWindow2(200, 200);
        Walker w1 = new Walker(iw1);
        iw1.openWindow("ImageWindow");
        w1.setPos(180, 180);
        w1.setColor(0, 0, 0);
        w1.setDir(-1, 0);
        w1.pressBallPen();
        hilbert(w1,1);

        // Image 2
        ImageWindow2 iw2 = new ImageWindow2(200, 200);
        Walker w2 = new Walker(iw2);
        iw2.openWindow("ImageWindow", 220, 0);
        w2.setPos(180, 180);
        w2.setColor(0, 0, 0);
        w2.setDir(-1, 0);
        w2.pressBallPen();
        hilbert(w2,2);

        // Image 2
        ImageWindow2 iw3 = new ImageWindow2(200, 200);
        Walker w3 = new Walker(iw3);
        iw3.openWindow("ImageWindow", 440, 0);
        w3.setPos(180, 180);
        w3.setColor(0, 0, 0);
        w3.setDir(-1, 0);
        w3.pressBallPen();
        hilbert(w3,3);
    }

    private static void hilbert(Walker w, int depth) {
        if (depth == 0) return;
        w.turn(90);
        hilbert2(w, depth-1);
        w.move(distance);
        w.turn(-90);
        hilbert(w, depth-1);
        w.move(distance);
        hilbert(w, depth-1);
        w.turn(-90);
        w.move(distance);
        hilbert2(w,depth-1);
        w.turn(90);
    }

    private static void hilbert2(Walker w, int depth) {
        if (depth == 0) return;
        w.turn(-90);
        hilbert(w, depth-1);
        w.move(distance);
        w.turn(90);
        hilbert2(w, depth-1);
        w.move(distance);
        hilbert2(w, depth-1);
        w.turn(90);
        w.move(distance);
        hilbert(w, depth-1);
        w.turn(-90);
    }
}
