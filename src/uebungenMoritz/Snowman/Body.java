package uebungenMoritz.Snowman;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

/**
 * This extension of Shape defines the Body
 * of a Snowman with some buttons.
 */
public class Body extends Shape {
    private Circle body;  // the body itself
    private Circle[] buttons; // the buttons

    /**
     * Creates a Body of a Snowman.
     * @param midpoint Center of the body.
     * @param radius Must be >= 0.
     * @param buttonnumber Must be >=0.
     */
    public Body(Point midpoint, int radius, int buttonnumber) {

        // body
        body = new Circle(midpoint, radius);

        // buttons
        buttons = new Circle[buttonnumber];   // number of buttons

        // one radius for all buttons
        int buttonradius = (int) radius/(2*buttonnumber);

        // buttons are placed with the same distance
        for(int i=0; i < buttons.length; i++) {
            buttons[i] = new Circle(new Point( midpoint.x,
                    midpoint.y-radius+
                            ((i+1)*2*radius/(buttonnumber+1)) ),
                    buttonradius);
            buttons[i].setColor(Color.red);
        }
    }

    /**
     * Alternative constructor of Body. Here the number of buttons
     * is 3.
     * @param midpoint Nothing to say.
     * @param radius Must be >= 0.
     */
    public Body(Point midpoint, int radius) {
        this( midpoint, radius, 3 );
    }

    /**
     * Sets the color of all buttons on the body.
     * @param col Nothing to say.
     */
    public void setButtonColor(Color col) {
        for(int i = 0; i < buttons.length; i++)
            buttons[i].setColor(col);  // Farbe der Buttons
    }

    /**
     * Sets the color for the body.
     * @param Nothing to say.
     */
    public void setBodyColor(Color col) {
        body.setColor(col);
    }

    /**
     * Draw method of Body. Paints the body and
     * all its buttons.
     * @param g Nothing to say.
     */
    public void draw(Graphics g) {
        body.draw(g);
        for(int i=0; i < buttons.length; i++)
            buttons[i].draw(g);
    }
}

