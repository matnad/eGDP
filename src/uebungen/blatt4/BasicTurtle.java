package uebungen.blatt4;

import ch.unibas.informatik.cs101.ImageWindow;

public class BasicTurtle {
    public static void main(String args[]) {
        //creates a new instance of the ImageWindow Class
        //with a viewable image area of 500x500 pixels
        ImageWindow w = new ImageWindow(500,500);

        //opens the corresponding window (makes it visible)
        w.openWindow();

        //create turtles
        Turtle turtle1 = new Turtle(w);
        Turtle turtle2 = new Turtle(w);

        //excercise 2.e.i
        turtle1.move(100);
        turtle1.toggle_pen();
        turtle1.turn_counter_clockwise();
        turtle1.move(50, 50, 100, 200);
        turtle1.turn_clockwise(1);
        turtle1.move(80, 250, 100, 200);
        turtle1.turn_counter_clockwise(1);
        turtle1.move(50, 0, 100, 100);
        turtle1.turn_clockwise(1);
        turtle1.move(90, 100, 100, 255);
        turtle1.turn_counter_clockwise();
        turtle1.move(150, 123, 221, 11);
        turtle1.turn_clockwise();
        turtle1.move(50, 222, 111, 0);

        //excercise 2.e.ii
        int step_size = 60;
        int[][] colors = {{0,0,255},{0,255,0},{255,0,0},{100,100,100}};

        turtle2.toggle_pen();
        for (int[] color: colors){
            turtle2.move(step_size, color[0], color[1], color[2]);
            turtle2.turn_clockwise();
            turtle2.move(step_size, color[0], color[1], color[2]);
            turtle2.turn_counter_clockwise();
            turtle2.move(step_size, color[0], color[1], color[2]);
            turtle2.turn_clockwise();
            turtle2.move(step_size, color[0], color[1], color[2]);
            turtle2.turn_clockwise();
            turtle2.move(step_size, color[0], color[1], color[2]);
            turtle2.turn_counter_clockwise();
            turtle2.move(step_size, color[0], color[1], color[2]);
            turtle2.turn_clockwise();
            turtle2.move(step_size, color[0], color[1], color[2]);
            turtle2.turn_counter_clockwise();
        }

    }
}
