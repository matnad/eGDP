package uebungen.blatt7;

import ch.unibas.informatik.cs101.ImageWindow;

import java.awt.Color;

public class Mandelbrot {

    private final ColorPalette colPal;
    private final int width;
    private final int height;
    private final ImageWindow sourceWindow;


    public static void main(String[] args) {
        int palette = Integer.parseInt(args[0]);
        double fact = Double.parseDouble(args[1]);
        long startTime, endTime;
        int width = (int) Math.round(64 * fact);
        int height = (int) Math.round(48 * fact);

        Mandelbrot m1 = new Mandelbrot(width, height, palette);
        startTime = System.currentTimeMillis();
        m1.show_mandelbrot(new Complex(-2.5, -1.3), 0.05/fact, 1000);
        System.out.println("Time MB1 not inplace: " + (System.currentTimeMillis() - startTime) + " ms.");

        startTime = System.currentTimeMillis();
        m1.show_mandelbrot_inplace(new Complex(-2.5, -1.3), 0.05 / fact, 1000);
        System.out.println("Time MB1 inplace: " + (System.currentTimeMillis() - startTime) + " ms.");


        Mandelbrot m2 = new Mandelbrot(width, height, palette);
        startTime = System.currentTimeMillis();
        m2.show_mandelbrot(new Complex(-0.755, -0.1), 0.0002/fact, 1000);
        System.out.println("Time MB2 not inplace: " + (System.currentTimeMillis() - startTime) + " ms.");

        startTime = System.currentTimeMillis();
        m2.show_mandelbrot_inplace(new Complex(-0.755, -0.1), 0.0002 / fact, 1000);
        System.out.println("Time MB2 not inplace: " + (System.currentTimeMillis() - startTime) + " ms.");
    }


    private Mandelbrot(int _width, int _height, int pal) {
        width = _width;
        height = _height;
        sourceWindow = new ImageWindow(width, height);
        sourceWindow.openWindow("mandelbrot", 0, 0);
        colPal = new ColorPalette(pal);
    }

    private void show_mandelbrot(Complex c_origin, double c_step, int max_iter) {
        /* Implementieren des Mandelbrot Algorithmus */

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                Complex c = new Complex((c_origin.real() + c_step * i), (c_origin.imag() + c_step * j));
                Complex z = new Complex(0, 0);
                int n = 0;
                for (; n <= max_iter; n++) {
                    z = z.sqr();
                    z = z.add(c);
                    if (z.abs_sqr() > 4)
                        break;
                }

                Color col = colPal.getColor(n, z);
                sourceWindow.setPixel(i, j, col.getRed(), col.getGreen(), col.getBlue());
            }
        }


        redraw();
    }

    private void show_mandelbrot_inplace(Complex c_origin, double c_step, int max_iter) {
        /* Implementieren des Mandelbrot Algorithmus */

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                Complex c = new Complex((c_origin.real() + c_step * i), (c_origin.imag() + c_step * j));
                Complex z = new Complex(0, 0);
                int n = 0;
                for (; n <= max_iter; n++) {
                    z.sqr_inplace().add_inplace(c);
                    if (z.abs_sqr() > 4)
                        break;
                }

                Color col = colPal.getColor(n, z);
                sourceWindow.setPixel(i, j, col.getRed(), col.getGreen(), col.getBlue());
            }
        }

        redraw();
    }

    private void redraw() {
        sourceWindow.redraw();
    }

}
