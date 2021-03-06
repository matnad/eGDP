package uebungen.blatt7;

import ch.unibas.informatik.cs101.ImageWindow;

import java.util.SplittableRandom;

class GameOfLife {
    private final int SIZE;
    private final boolean[][] field;
    private ImageWindow W;
    private final int pixelSize = 10;
    private final boolean image;

    GameOfLife() {
        this.SIZE = 6;
         field = new boolean[][] {{false, false, false, false, false, false},
                {false, true, false, true, false, false},
                {false, false, true, true, false, false},
                {false, false, true, false, false, false},
                {false, false, false, false, false, false},
                {false, false, false, false, false, false}};
        this.image = false;
    }

    GameOfLife(int size, boolean image) {
        this.SIZE = size;
        field = new boolean[SIZE][SIZE];
        this.image = image;
        if (image) {
            W = new ImageWindow(pixelSize * SIZE, pixelSize * SIZE);
            W.openWindow();
        }

        randomStart();
    }
    private GameOfLife(int size) {
        this(size, false);
    }

    private void randomStart() {
        SplittableRandom rng = new SplittableRandom();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if ( rng.nextInt(10) < 3)
                    field[i][j] = true;
            }
        }
    }

    void update() {
        // Copy grid
        boolean[][] f = new boolean[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(field[i], 0, f[i], 0, SIZE);
        }

        // Update copy
        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                int NB = countAliveNB(x,y);
                if( isAlive(x,y) ) {
                    if (NB < 2 || NB > 3)
                        f[x][y] = false;
                } else {
                    if (NB == 3)
                        f[x][y] = true;
                }
            }
        }

        // Copy back
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(f[i],0, field[i],0, SIZE);
        }

    }

    private int countAliveNB(int x, int y) {
        int NB = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i==0 && j==0)
                    continue;

                if (isAlive(x+i, y+j))
                    NB++;
            }
        }

        return NB;
    }

    private boolean isAlive(int x, int y) {
        int wrapX = (x+SIZE) % SIZE;
        int wrapY = (y+SIZE) % SIZE;
        return field[wrapX][wrapY];
    }

    @Override
    public String toString() {
        StringBuilder outGrid = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(field[i][j])
                    outGrid.append("@");
                else
                    outGrid.append(".");
            }
            outGrid.append("\n");
        }
        return outGrid.toString();
    }

    public void redraw() {
        if (!image)
            return;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                for (int k = 0; k < pixelSize; k++) {
                    for (int l = 0; l < pixelSize; l++) {
                        if (isAlive(i,j))
                            W.setPixel(i*pixelSize+k, j*pixelSize+l, 0,0,0 );
                        else
                            W.setPixel(i*pixelSize+k, j*pixelSize+l, 255, 255, 255);
                    }
                }
            }
        }
        W.redraw();
    }
}
