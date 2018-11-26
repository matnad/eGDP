package uebungenMoritz.Snowman;

import java.awt.Graphics;
import java.awt.Point;

/**
 * This extension of Shape defines a Rectangle
 * by two corners.
 */
public class Rectangle extends Shape {
    private Point min;  // lower left corner
    private Point max;  // upper right corner

    /**
     * Creates a Rectangle through two points.
     * @param pmin The lower left corner.
     * @param pmax The upper right corner.
     */
    public Rectangle(Point pmin, Point pmax) {
        min = pmin;
        max = pmax;
    }

    /**
     * Draw method for Rectangle. The Rectangle is
     * painted and filled.
     * @param g Nothing to say.
     */
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(min.x,min.y,max.x-min.x,max.y-min.y);
    }
}

