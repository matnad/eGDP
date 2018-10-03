package uebungen.blatt2;

import ch.unibas.informatik.cs101.ImageWindow;

public class Rechteck {
    public static void main(String args[]) {
        //creates a new instance of the ImageWindow Class
        //with a viewable image area of 500x500 pixels
        int dim = 500;
        ImageWindow w = new ImageWindow(dim,dim);

        //opens the corresponding window (makes it visible)
        w.openWindow();

        //draw rectangle
        for (int i = 100; i <= 400; i++) {
            for (int j = 200; j <= 300; j++) {
                w.setPixel(i, j, 0, 0, 0);
            }

        }

        //redraws the image on the screen so all changes
        //become visible
        w.redraw();
    }
}
