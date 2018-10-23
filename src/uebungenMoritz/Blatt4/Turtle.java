package uebungenMoritz.Blatt4;
import ch.unibas.informatik.cs101.ImageWindow;

public class Turtle {


    private ImageWindow w;
    private int[] pos = new int[2];
    private boolean pen;
    private int direction;


    public Turtle(ImageWindow w) {
        this.w = w;
        pos[1] = this.w.getWidth() / 2; // x-axis
        pos[0] = this.w.getHeight() / 2; // y-axis
        direction = 1;
        pen = false;
    }

    public void turn_pen() {
        pen = !pen;
    }

    public void turn(int turn_num) {
        if (turn_num < 0) {
            turn_num = Math.abs(turn_num);
        }
        direction = direction + turn_num;
        direction = direction % 4;

    }
    public void move(){move(10);
    }
    public void move(int step){ move(step, 255,0, 0);
    }

    public void move(int step, int red, int green, int blue) {
        if (step == 0) step = 10;


        if (pen) {
            int x = pos[0];
            int y = pos[1];
            for (int i = 0; i < step; i++) {
                switch (direction) {

                    case 0: y--;break;
                    case 1: x++;break;
                    case 2: y++;break;
                    case 3: x--;break;
                }
                w.setPixel(x, y, red, green, blue);
            }
            w.redraw();
            pos[0] = x; pos[1] = y;
        } else {
            for (int i = 0; i < step; i++) {
                switch (direction) {
                    case 0: pos[1]--;break;
                    case 1: pos[0]++;break;
                    case 2: pos[1]++;break;
                    case 3: pos[0]--;break;

                }
            }
        }
    }
}


