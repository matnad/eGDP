package uebungen.blatt10.adam;

public class Buzzer {

    private static int counter;
    private boolean pressed;

    static public int getCounter() {
        return counter;
    }

    static public void resetCounter() {
        counter = 0;
    }

    void buzz() {
        if (!pressed) {
            pressed = true;
            counter++;
        }
    }

    void resetBuzzer() {
        pressed = false;
    }
}
