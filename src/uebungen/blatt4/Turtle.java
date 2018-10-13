package uebungen.blatt4;

import ch.unibas.informatik.cs101.ImageWindow;

/**
 * Generates a turtle object in the middle of an ImageWindow that can be moved and turned
 * Optionally the turtle will leave a trail in a specified color
 * It can move in the 4 basic directions and wrap around the Image
 */
public class Turtle {
    private final ImageWindow w;
    private final int[] pos = new int[2];
    private int direction; // 4 directions. 0 = north
    private boolean pen;

    /**
     * Initialize Turtle in the middle of the window
     * Pen is lifted and the direction is positive x axis
     * @param w the ImageWindow to draw in
     *
     * x and y axes are "reversed" to allow pos[direction % 2] to get the correct axis to move along
     */
    public Turtle(ImageWindow w){
        this.w = w;
        pos[1] = this.w.getWidth()/2; // x-axis
        pos[0] = this.w.getHeight()/2; // y-axis
        direction = 1;
        pen = false;
    }

    /**
     * Put the pen down if it is not. Lift the pen if it is down.
     */
    public void toggle_pen(){
        pen = !pen;
    }

    /**
     * Turn the turtle clockwise x times
     * @param turn_x_times
     * All the following methods call this one with different parameters
     */
    public void turn_clockwise(int turn_x_times){
        if (turn_x_times < 0)
            turn_x_times = Math.abs(turn_x_times) + 2;
        direction += turn_x_times;
        direction %= 4;
    }

    public void turn_clockwise(){
        turn_clockwise(1);
    }

    public void turn_counter_clockwise(int turn_x_times){
        turn_clockwise(2 + turn_x_times);
    }

    public void turn_counter_clockwise (){
        turn_counter_clockwise(1);
    }


    /**
     * Move the turtle in the direction it is facing and draw a colored line if pen is true
     * @param step the amount of pixels to move
     * @param red the red part of the color 0-255
     * @param green the green part of the color 0-255
     * @param blue the blue part of the color 0-255
     */
    public void move(int step, int red, int green, int blue){
        int height = w.getHeight();
        int width = w.getWidth();
        if(pen){
            int x = pos[1];
            int y = pos[0];
            for (int s=0; s<step; s++){
                switch (direction){
                     // We need modulo to allow the turtle to wrap around the Image
                    case 0: y--; y = (y+height) % height; break;
                    case 1: x++; x %= width; break;
                    case 2: y++; y %= height; break;
                    case 3: x--; x = (x+width) % w.getWidth(); break;
                }
                w.setPixel(x, y, red, green, blue);
            }
            w.redraw();
            // position is already updated, just save it to the class variables
            pos[0] = y; pos[1] = x;
        } else {
            switch (direction){
                // We need modulo to allow the turtle to wrap around the Image
                case 0: pos[0] -= step; pos[0] = (pos[0]+height) % height; break;
                case 1: pos[1] += step; pos[1] %= width; break;
                case 2: pos[0] += step; pos[0] %= height; break;
                case 3: pos[1] -= step; pos[1] = (pos[1]+width) % width; break;
            }
        }


    }

    /**
     * Move 1 step with default color
     */
    public void move(){
        move(1);
    }

    /**
     * Move the turtle and use the default color black
     * @param step the amount of pixels to move
     */
    public void move(int step){
        move(step, 0,0, 0);
    }
}
