package uebungenMoritz.Blatt9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GOLFenster extends Component {
    private static int a;

    public static void main(String[] args) {
        a = Integer.parseInt(args[0]);
        GOLFenster golFenster = new GOLFenster(new GameOfLife(a/4));
        golFenster.run(2000);
    }


    GameOfLife gameOfLife;
    JFrame jFrame;

    private GOLFenster(GameOfLife gameOfLife) {
        this.gameOfLife = gameOfLife;
        jFrame = new JFrame("Game of Life");
        jFrame.setSize( a+15, a+38 );
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(this);
        this.addMouseListener();
        jFrame.paint(jFrame.getGraphics());



    }

    private void run(int n){
        for (int i = 0; i < n; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gameOfLife.feld = gameOfLife.tauschen(gameOfLife.feld);
            redraw();
        }
    }

    public void paint(Graphics g) {

        for (int i = 0; i < gameOfLife.x; i++) {
            for (int j = 0; j < gameOfLife.x; j++) {
                if (gameOfLife.feld[i][j])
                    g.setColor(Color.black);
                else
                    g.setColor(Color.white);
                g.fillRect(j*4,i*4, 4, 4);
            }
        }
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 15));
                g.drawString("Generation " + gameOfLife.generation, 0, 12);
    }
    public void redraw() {
        jFrame.repaint();
    }



     private void addMouseListener(){
        this.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                int x = e.getX()/4;
                int y = e.getY()/4;
                if(!gameOfLife.feld[y][x]){
                    gameOfLife.feld[y][x] = true;
                }

            }
            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });
    }
}