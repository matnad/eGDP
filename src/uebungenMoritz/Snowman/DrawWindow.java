package uebungenMoritz.Snowman;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

/**
 * This class is a window for a ShapeList.
 * The Shapes are painted in a Frame.
 */
public class DrawWindow extends Frame implements WindowListener {
    private ShapeList list;    // list of Shape elements

    /**
     * Creates a new Frame for the Winter Scene.
     * @param width Width of the Frame. Must be >= 0.
     * @param height Height of the Frame. Must be >= 0.
     */
    public DrawWindow(int width, int height, ShapeList elements) {
        // Frame parameters
        setSize(width, height);
        setTitle("Winter Scenes");
        show();

        // this class handles the window events
        addWindowListener(this);

        // the ShapeList to be drawn
        list = elements;
    }

    /**
     * Paints the given list of Shapes.
     * @param g Nothing to say.
     */
    public void paint(Graphics g) {
        // trivial case
        if (list==null)
            return;

        // go through the non-empty list
        ShapeNode x = list.getHead();
        while(x != null) {
            x.getData().draw(g);   // draw the Shape
            x=x.getNext();         // switch to the next
        }
        return;
    }

    /**
     * Closes the window if desired and exits the whole program.
     * @param e Nothing to say.
     */
    public void windowClosing(WindowEvent e) {
        setVisible(false);
        dispose();
        System.exit(0);
    }

    /** Empty implementation for interface WindowListener */
    public void windowActivated(WindowEvent e) { }
    /** Empty implementation for interface WindowListener */
    public void windowClosed(WindowEvent e) { }
    /** Empty implementation for interface WindowListener */
    public void windowDeiconified(WindowEvent e) { }
    /** Empty implementation for interface WindowListener */
    public void windowIconified(WindowEvent e) { }
    /** Empty implementation for interface WindowListener */
    public void windowOpened(WindowEvent e) { }
    /** Empty implementation for interface WindowListener */
    public void windowDeactivated(WindowEvent e) { }
}


