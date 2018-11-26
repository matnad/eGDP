package uebungenMoritz.Snowman;

import java.awt.Graphics;
import java.awt.Color;

/**
 * This is a class that defines an
 * abstract shape. It ensures that every subclass
 * implements a draw method.
 */
public abstract class Shape {
    protected Color color = Color.black; // color of the object

    /**
     * Gives back the color.
     * @return The color of the Shape.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the color of the Shape
     * @param col Nothing to say.
     */
    public void setColor(Color col) {
        color = col;
    }

    /**
     * An abstract method which ensures that every
     * subclass of Shape implements a draw method.
     * @param g Nothing to say.
     */
    public abstract void draw(Graphics g);
}



