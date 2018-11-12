package uebungenMoritz.Blatt7;
import ch.unibas.informatik.cs101.ImageWindow;
import java.awt.Color;

public class Mandelbrot {

    ColorPalette colPal;
    int width;
    int height;
    public ImageWindow sourceWindow;


    public static void main(String[] args) {
        int palette = Integer.parseInt(args[0]);
        double fact = Double.parseDouble(args[1]);
        long startTime = 0, endTime;
        int width = (int) Math.round(64 * fact);
        int height = (int) Math.round(48 * fact);

        Mandelbrot m1 = new Mandelbrot( width, height, palette);
        m1.show_mandelbrot(new Complex(-2.5, -1.3), 0.05/fact, 1000);

        endTime=System.currentTimeMillis();

        //m1.show_mandelbrot_inplace(new Complex(-2.5, -1.3), 0.05/fact, 255);

        long notinplace = endTime-startTime;
        startTime = 0;

        Mandelbrot m2 = new Mandelbrot( width, height, palette);
        //m2.show_mandelbrot(new Complex(-0.755, -0.1), 0.0002/fact, 1000);
        m2.show_mandelbrot_inplace(new Complex(-0.755, -0.1), 0.0002/fact, 1000);
        endTime=System.currentTimeMillis();
        long inplace = endTime-startTime;
        long difference = notinplace-inplace;
        System.out.println("Time without inplace: "+ notinplace + " and the time with inplace: " + inplace + "The difference is: " + difference);

    }


    public Mandelbrot(int _width, int _height, int pal) {
        width = _width;
        height = _height;
        sourceWindow = new ImageWindow(width,height);
        sourceWindow.openWindow("mandelbrot",0,0);
        colPal = new ColorPalette(pal);
    }

    void show_mandelbrot(Complex c_origin, double c_step, int max_iter) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int flug = max_iter;
                Complex z0 = new Complex((c_origin.real()+c_step*i), (c_origin.imag()+c_step*j));
                Complex z=z0;
                for (int t = 0; t < max_iter; t++) {
                    if (z.abs_sqr() > 2.0) {flug=t; break;}
                    else { z = z.sqr().add(z0); }
                }
                Color col = colPal.getColor(flug, z);
                sourceWindow.setPixel(i, j, col.getRed(), col.getGreen(), col.getBlue());
            }
        }
        redraw();
    }

    void show_mandelbrot_inplace(Complex c_origin, double c_step, int max_iter) {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int flug = max_iter;
                Complex z0 = new Complex((c_origin.real()+c_step*i), (c_origin.imag()+c_step*j));
                Complex z= new Complex(z0.a, z0.b);
                for (int t = 0; t < max_iter; t++) {
                    if (z.abs_sqr() > 2.0) {flug=t; break;}
                    else { Complex a = z.sqr_inplace();
                        z = a.add_inplace(z0); }
                }
                Color col = colPal.getColor(flug, z);
                sourceWindow.setPixel(i, j, col.getRed(), col.getGreen(), col.getBlue());
            }
        }
        redraw();
    }

    public void redraw() {
        sourceWindow.redraw();
    }
    public void setPixel(int r, int g, int b, int x, int y)  {
        sourceWindow.setPixel(r, g, b, x, y);
    }

}