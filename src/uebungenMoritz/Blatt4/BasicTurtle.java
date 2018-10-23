package uebungenMoritz.Blatt4;
import ch.unibas.informatik.cs101.ImageWindow;

public class BasicTurtle {




        public static void main(String args[]) {
            //creates a new instance of the ImageWindow Class
            //with a viewable image area of 500x500 pixels
            ImageWindow w = new ImageWindow(500, 500);

            //opens the corresponding window (makes it visible)
            w.openWindow();

            Turtle turtle1 = new Turtle(w);
            Turtle turtle2 = new Turtle(w);

            turtle1.move(130);
            turtle1.turn_pen();
            turtle1.move(50, 255, 0, 0);
            turtle1.turn(1);
            turtle1.move(40, 0, 255, 0);
            turtle1.turn(3);
            turtle1.move(60, 255, 0, 0);
            turtle1.turn(1);
            turtle1.move(30, 0, 255, 0);
            turtle1.turn(1);
            turtle1.move(65, 255, 255, 0);
            turtle1.turn(3);
            turtle1.move(35, 0, 255, 0);
            turtle1.turn(1);
            turtle1.move(55, 255, 255, 0);


            int[] colors = {0, 255, 150, 255,0};
                turtle2.turn(2);
                turtle2.move(100);
                turtle2.turn(1);
                turtle2.move(150);
                turtle2.turn_pen();
            for (int i = 0; i < colors.length; i++) {

                turtle2.move(40,colors[i+1],0,colors[i]);
                turtle2.turn(1);
                turtle2.move(40,colors[i+1],0,colors[i]);
                turtle2.turn(3);
                turtle2.move(40,colors[i+1],0,colors[i]);
                turtle2.turn(1);
                turtle2.move(40,colors[i+1],0,colors[i]);
                turtle2.turn(1);
                turtle2.move(40,colors[i+1],0,colors[i]);
                turtle2.turn(3);
                turtle2.move(40,colors[i+1],0,colors[i]);
                turtle2.turn(1);
                turtle2.move(40,colors[i+1],0,colors[i]);
                turtle2.turn(3);

            }
        }
}
