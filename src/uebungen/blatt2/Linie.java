package uebungen.blatt2;

import ch.unibas.informatik.cs101.ImageWindow;

public class Linie {
    public static void main(String args[]) {
        //creates a new instance of the ImageWindow Class
        //with a viewable image area of 500x500 pixels
        final int dim = 500;

        ImageWindow w = new ImageWindow(dim,dim);

        //opens the corresponding window (makes it visible)
        w.openWindow();

        //draw lines
        for (int i = 0; i <= dim; i++) {
            w.setPixel(i, 100, 0, 0, 0);
            w.setPixel(200, i, 0, 0, 0);
        }

        //redraws the image on the screen so all changes
        //become visible
        w.redraw();
    }
}
