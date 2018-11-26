package uebungenMoritz.Snowman;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics;

/**
 * This extension of Shape defines a Snowman with
 * Face and Body. A Snowman is considered as a rectangle
 * that is given by its lower left corner and its height.
 */
public class Snowman extends Shape {
    private Point min;  // lower left corner
    private int height; // snowmans's height
    Face face;  // snowman's face
    Body body;  // snowman's body

    /**
     * Creates a Snowman.
     * @param pmin Lower left corner.
     * @param sheight Height of the Snowman. Must be >= 0.
     */
    public Snowman( Point pmin, int sheight ) {
        min = pmin;
        height = sheight;

        // face:body = 1:2
        // radius of body and face
        int bodyrad = (int)height/3;
        int facerad = (int)height/6;

        // the width of the snowman
        int width = 2*bodyrad;

        // the midpoints of face and body
        Point bodymidpoint = new Point( min.x + (int)(width/2),
                min.y - bodyrad  );

        Point facemidpoint = new Point( min.x + (int)(width/2),
                min.y - (2*bodyrad+facerad));

        // now face and body can be set up
        face = new Face(facemidpoint, facerad);
        face.setColor(Color.yellow);
        face.setEyeColor(Color.black);
        body = new Body(bodymidpoint, bodyrad, 4);
        body.setColor(Color.blue);
    }

    /**
     * Draw method of Snowman. Paints face and body.
     * @param g Nothing to say.
     */
    public void draw(Graphics g) {
        face.draw(g);  // Zeichne das Face
        body.draw(g);  // Zeichne den Body
    }
}


