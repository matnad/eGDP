package uebungen.blatt8;

import ch.unibas.informatik.cs101.ImageWindow2;
import ch.unibas.informatik.cs101.Walker;

public class KochWalk {

    private static final double baseDistance = 3.1415;
    private static double distance;
    private static final double angle = 60;//45.59;

    public static void main (String[] args) {

        // Image 1
        ImageWindow2 iw1 = new ImageWindow2(200, 100);
        Walker w1 = new Walker(iw1);
        iw1.openWindow("ImageWindow");
        w1.setPos(30, 65);
        w1.setColor(255, 0, 0);
        w1.setDir(1, 0);
        w1.pressBallPen();
        distance = baseDistance * 10;
        drawRecursive(w1,1);

        // image 2
        ImageWindow2 iw2 = new ImageWindow2(300, 150);
        Walker w2 = new Walker(iw2);
        iw2.openWindow("ImageWindow", 220, 0);
        w2.setPos(30, 110);
        w2.setColor(150, 0, 150);
        w2.setDir(1, 0);
        w2.pressBallPen();
        distance = baseDistance * 7;
        drawRecursive(w2,2);

        // image 3
        ImageWindow2 iw3 = new ImageWindow2(700, 250);
        Walker w3 = new Walker(iw3);
        iw3.openWindow("ImageWindow", 0, 200);
        w3.setPos(30, 170);
        w3.setColor(0, 0, 255);
        w3.setDir(1, 0);
        w3.pressBallPen();
        distance = baseDistance * 5;
        drawRecursive(w3,3);

        // image 4
        ImageWindow2 iw4 = new ImageWindow2(700, 700);
        Walker w4 = new Walker(iw4);
        iw4.openWindow("ImageWindow", 720, 0);
        w4.setPos(50, 170);
        w4.setColor(150, 0, 150);
        w4.setDir(1, 0);
        w4.pressBallPen();
        distance = baseDistance * 7;
        snowflake(w4,3);

    }

    private static void drawRecursive(Walker w, int depth){
        if (depth == 0) {
            w.move(distance);
            return;
        }
        drawRecursive(w, depth-1);
        w.turn(-angle);
        drawRecursive(w, depth-1);
        w.turn(2*angle);
        drawRecursive(w, depth-1);
        w.turn(-angle);
        drawRecursive(w, depth-1);
    }

    private static void snowflake(Walker w, int depth){
        drawRecursive(w, depth);
        w.turn(120);
        drawRecursive(w, depth);
        w.turn(120);
        drawRecursive(w, depth);
    }
}
