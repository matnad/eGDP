package uebungenMoritz.Snowman;

import java.awt.Graphics;
import java.awt.Point;

/**
 * This extension of Shape defines a Circle
 * by point and radius.
 */
public class Circle extends Shape {
    private Point m; // center
    private int r;   // radius

    /**
     * Creates a new Circle.
     * @param midpoint Nothing to say.
     * @param radius Must be >= 0.
     */
    public Circle(Point midpoint, int radius) {
        m = midpoint;
        r = radius;
    }

    /**
     * Draw method for Circle. Paints the Circle
     * as a filled oval.
     * @param g Nothing to say.
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(m.x-r,m.y-r,2*r,2*r);
    }
}

