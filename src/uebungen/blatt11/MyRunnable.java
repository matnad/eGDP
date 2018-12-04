package uebungen.blatt11;

public class MyRunnable implements Runnable {
    private static int sum = 0;
    private int value = 0;

    MyRunnable(int value) {
        this.value = value;
    }

    public void run() {
        addValue(value);
    }

    private synchronized static void addValue(int summand) {
        sum += summand;
    }

    public int getValue() {
        return value;
    }

    public static int getSum() {
        return sum;
    }
}