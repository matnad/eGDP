package uebungenMoritz.Snowman;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

/**
 * This extension of Shape defines the Face
 * of a Snowman with eyes, nose and mouth.
 */
public class Face extends Shape {
    private Circle face;     // the face itself
    private Circle leftEye;  // one eye
    private Circle rightEye; // the other eye
    private Triangle nose;   // the nose
    private Rectangle mouth; // the mouth

    /**
     * Creates a new Face.
     * @param midpoint Nothing to say.
     * @param radius Must be >= 0.
     */
    public Face(Point midpoint, int radius) {

        // The different components are placed relative
        // to the midpoints. Their sizes dependent only
        // on the radius.

        // Face
        face = new Circle(midpoint, radius);

        // Eyes
        Point leftEyePos = new Point(midpoint.x, midpoint.y);
        Point rightEyePos = new Point(midpoint.x, midpoint.y);

        leftEyePos.translate(-(int)(0.4*radius), -(int)(0.4*radius));
        rightEyePos.translate((int)(0.4*radius), -(int)(0.4*radius));

        leftEye = new Circle(leftEyePos, radius/4);
        rightEye = new Circle(rightEyePos, radius/4);

        leftEye.setColor(Color.yellow);
        rightEye.setColor(Color.yellow);

        // Nose
        Point p1 = new Point(midpoint.x, midpoint.y);
        Point p2 = new Point(midpoint.x, midpoint.y);
        Point p3 = new Point(midpoint.x, midpoint.y);

        p1.translate(-(int)(0.2*radius), (int)(0.2*radius));
        p2.translate((int)(0.2*radius), (int)(0.2*radius));
        p3.translate(0, -(int)(0.4*radius));

        nose = new Triangle(p1, p2, p3);
        nose.setColor(Color.blue);

        // Mouth
        Point min = new Point(midpoint.x, midpoint.y);
        Point max = new Point(midpoint.x, midpoint.y);

        min.translate(-(int)(0.4*radius), (int)(0.4*radius));
        max.translate((int)(0.4*radius), (int)(0.6*radius));

        mouth = new Rectangle(min, max);
        mouth.setColor(Color.red);
    }

    /**
     * Sets the color of the whole face.
     * @param col Nothing to say.
     */
    public void setColor(Color col) {
        super.setColor(col);
        face.setColor(col);
    }

    /**
     * Sets the color for both eyes together.
     * @param col Nothing to say.
     */
    public void setEyeColor(Color col) {
        leftEye.setColor(col);
        rightEye.setColor(col);
    }

    /**
     * Sets the color of the nose.
     * @param col Nothing to say.
     */
    public void setNoseColor(Color col) {
        nose.setColor(col);
    }

    /**
     * Sets the color of the mouth.
     * @param col Nothing to say.
     */
    public void setMouthColor(Color col) {
        mouth.setColor(col);
    }

    /**
     * Draw method for Face. Paints all components
     * face, eyes, nose, mouth.
     * @param g Nothing to say.
     */
    public void draw(Graphics g) {
        face.draw(g);
        leftEye.draw(g);
        rightEye.draw(g);
        nose.draw(g);
        mouth.draw(g);
    }
}
