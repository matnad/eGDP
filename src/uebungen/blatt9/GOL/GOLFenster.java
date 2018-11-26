package uebungen.blatt9.GOL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GOLFenster extends Component {

    private GameOfLife gameOfLife;
    private final int CELLSIZE = 5;
    private JFrame jFrame;

    private GOLFenster(GameOfLife gameOfLife) {
        this.gameOfLife = gameOfLife;
        jFrame = new JFrame("Game of Life");
        jFrame.add(this);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseListener();

        jFrame.paint(jFrame.getGraphics());
        jFrame.pack();
    }

    public static void main(String[] args) {
        GOLFenster golFenster = new GOLFenster(new GameOfLife(150));
        golFenster.run(2000);
    }

    private void run(int n){
        for (int i = 0; i < n; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            gameOfLife.update();
            redraw();
        }
    }

    private void addMouseListener(){
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = e.getX();
                int j = e.getY();
                int cordX = j / CELLSIZE;
                int cordY = i / CELLSIZE;
                gameOfLife.resurrect(cordX, cordY);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public Dimension getPreferredSize() {
        int golSize = gameOfLife.getSize();
        int jFrameSize = golSize * CELLSIZE;
        return new Dimension(jFrameSize, jFrameSize);
    }

    public void paint(Graphics g) {
        for (int i = 0; i < gameOfLife.getSize(); i++) {
            for (int j = 0; j < gameOfLife.getSize(); j++) {
                if (gameOfLife.isAlive(i,j))
                    g.setColor(Color.black);
                else
                    g.setColor(Color.white);
                g.fillRect(j*CELLSIZE,i*CELLSIZE, CELLSIZE, CELLSIZE);
            }
        }
    }

    public void redraw() {
        jFrame.repaint();
    }
}
