package uebungenMoritz.Snowman;

import java.awt.Graphics;
import java.awt.Point;

/**
 * This extension of Shape defines a Triangle
 * with its three points.
 */
public class Triangle extends Shape {
    private int xPoints[]; // array for the x-values
    private int yPoints[]; // array for the y-values

    /**
     * Creates a Triangle by three given points.
     * @param p1 Nothing to say.
     * @param p2 Nothing to say.
     * @param p3 Nothing to say.
     */
    public Triangle(Point p1, Point p2, Point p3) {
        xPoints = new int[3];
        yPoints = new int[3];

        // we do this for the draw method
        xPoints[0] = p1.x;
        yPoints[0] = p1.y;
        xPoints[1] = p2.x;
        yPoints[1] = p2.y;
        xPoints[2] = p3.x;
        yPoints[2] = p3.y;
    }

    /**
     * Draw method for Triangle which paints it
     * as a filled polygon.
     * @param g Nothing to say.
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillPolygon(xPoints, yPoints, 3);
    }
}

