package uebungen.blatt2;

import ch.unibas.informatik.cs101.ImageWindow;

public class KreisMitte {
    public static void main(String args[]) {
        //creates a new instance of the ImageWindow Class
        //with a viewable image area of 500x500 pixels
        final int dim = 500;
        ImageWindow w = new ImageWindow(dim,dim);

        //opens the corresponding window (makes it visible)
        w.openWindow();

        //draw circle
        int m = dim/2;
        int r = 150;

        for (int i = 0; i <= dim; i++) {
            for (int j = 0; j <= dim; j++) {
                int c = ((i-m)*(i-m) + (j-m)*(j-m) <= r*r) ? 0 : 255;
                w.setPixel(i, j, c, c, c);
            }
        }

        //redraws the image on the screen so all changes
        //become visible
        w.redraw();
    }
}
