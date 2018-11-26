package uebungenMoritz.Snowman;

import java.awt.Graphics;
import java.awt.Point;

/**
 * This extension of Shape defines a Snowflake
 * that is simply a "*" character.
 */

public class Snowflake extends Shape {

    private final String flake = "*";  // flake
    private int x;   // x-value of the flake
    private int y;   // y-value of the flake

    /**
     * Creates a new Snowflake at a given point.
     * @param p Nothing to say.
     */
    public Snowflake(Point p) {
        x = p.x;
        y = p.y;
    }

    /**
     * Creates a new Snowflake with position
     * given in x-y-values.
     * @param x Must be >= 0.
     * @param y Must be >= 0.
     */
    public Snowflake(int x, int y) {
        this( new Point(x, y) );
    }

    /**
     * Draw method of Snowflake. Writes the flake string
     * at the desired location.
     * @param g Nothing to say.
     */
    public void draw(Graphics g) {
        g.drawString(flake, x, y);
    }
}



