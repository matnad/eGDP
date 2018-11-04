package uebungen.blatt7;

public class BasicGOL {

    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife(80, true);

        for (int i = 0; i < 1000; i++) {
            //System.out.println(gol);
            gol.update();
            gol.redraw();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
