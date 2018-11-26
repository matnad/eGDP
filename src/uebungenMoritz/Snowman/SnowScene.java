package uebungenMoritz.Snowman;

import java.awt.Point;
import java.awt.Color;

/**
 * This class adds several Shape objects to a ShapeList
 * and calls DrawWindow to paint them.
 */
public class SnowScene {
    DrawWindow win;    // the window to paint
    ShapeList list;    // Shapes to be painted

    /**
     * Creates a SnowScene with two snowmen,
     * some flakes and gives a ShapeList to DrawWindow.
     */
    public SnowScene() {
        list = new ShapeList();  // create empty list

        // Adding two Snowman objects to the list
        Snowman sm1 = new Snowman(new Point(200, 475), 250);
        list.insertFirst(sm1);

        Snowman sm2 = new Snowman(new Point(400, 400), 200);
        sm2.body.setBodyColor(Color.blue);
        list.insertFirst(sm2);

        // Adding Snowflake objects to the list
        for(int i = 0; i < 120; i++) {
            list.insertFirst(new Snowflake((int)(600*Math.random()),
                    (int)(600*Math.random())));
        }

        // Create a DrawWindow to paint the objects in the list
        win = new DrawWindow(600, 600, list);
    }

    /**
     * Test of SnowScene
     */
    public static void main(String args[]) {
        SnowScene sc = new SnowScene();
    }
}
