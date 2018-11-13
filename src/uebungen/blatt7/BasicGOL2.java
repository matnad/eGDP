package uebungen.blatt7;

public class BasicGOL2 {

    public static void main(String[] args) {
        GameOfLife gol = new GameOfLife();

        for (int i = 0; i < 20; i++) {
            System.out.println(gol);
            gol.update();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
