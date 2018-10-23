package uebungen.blatt4;

import ch.unibas.informatik.cs101.ImageWindow;

public class BubbleSortVis {

    /**
     * Define global variables for the class
     * Colors and dimension can be changed freely
     */
    private static int dim = 500;
    private static final int[] low_color = {0, 0, 255}; // blue
    private static final int[] high_color = {255, 100, 0}; // orange

    /**
     * No changes needed here
     */
    private static final int[] diff_color = {0,0,0}; // difference of the colors. Will be set in main
    private static int bar_width;
    private static char char_min;
    private static double char_diff;
    private static ImageWindow w;


    /**
     * Swaps to characters in array at the specified positions
     * @param i position of the first character 0-array_length
     * @param j position of the second character 0-array_length
     * @param characters array with characters of length array_length
     **/
    private static void swap(int i, int j, char[] characters) {
        char temp = characters[i];
        characters[i] = characters[j];
        characters[j] = temp;
    }

    /**
     * Sorts the input array in place
     * @param characters array with characters to be sorted
     **/
    private static void sort(char[] characters) {
        boolean done = false;

        while(!done){
            done = true;
            for(int i=0; i<characters.length-1; i++){
                if (characters[i+1] < characters[i]) {
                    swap(i, i + 1, characters);
                    done = false;
                    drawArray(characters, w); // draw the array after each swap
                }
            }
        }
    }

    /**
     * Draw the array in an Image Window with color and height sensitive bars
     * @param characters input array with characters to be displayed
     * @param w image window to draw into with dimension dim,dim
     **/
    private static void drawArray(char[] characters, ImageWindow w) {
        // Loop over character array and draw each bar individually.
        int x_pos = 0;
        for (char character: characters) {
            int red; int green; int blue;
            /*
             * Get a normalized value of the current character
             * 0 = lowest character in array
             * 1 = highest character in array
             */
            double normalized_value = (character - char_min) / char_diff;

            /*
             * Scale normalized value with dimension to get bar height
             * Then scale normalized value with colors to get an intermediate color
             */
            int bar_height_inverse = dim - (int) (normalized_value * dim);
            red = low_color[0] + (int) (normalized_value * diff_color[0]);
            green = low_color[1] + (int) (normalized_value * diff_color[1]);
            blue = low_color[2] + (int) (normalized_value * diff_color[2]);

            /*
             * Fill the region of the bar with the generated color.
             * We fill the rest of the segment white so we don't have to clear the image first
             */
            for(int x = x_pos; x < x_pos+bar_width; x++){
                for(int y = 0; y < dim; y++){
                    if (y >= bar_height_inverse)
                        w.setPixel(x,y,red,green,blue);
                    else
                        w.setPixel(x,y,255,255,255);
                }
            }

            x_pos += bar_width; // move to the position of the next bar
        }

        /*
         * Redraw the image and wait so we can see the progress happen.
         */
        w.redraw();
        w.pause(10);
    }

    /**
     * Print the array to the console
     * @param characters character array to print
     **/
    private static void displayArray(char[] characters) {
        System.out.println(characters);
    }

    /**
     * Main function. Reads input to an array and sets up some global variables.
     * Then calls the sorting method.
     **/
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Bitte rufen Sie das Programm mit einem Eingabewert auf");
            System.out.println("  java BubbleSort 'dies ist ein text'");
            System.exit(-1);
        }

        /*
         * Set up char array
         */
        char[] characters = args[0].toCharArray();
        //String test = "!?ThE-qUiCk'bRoWn=fOx]JuMpS&oVEr$tHe#LaZy}DOg";
        //char[] characters = test.toCharArray();

        /*
         * Generate color difference array
         */
        for (int i=0; i<3; i++)
            diff_color[i] = high_color[i]-low_color[i];

        /*
         * Get max and min value in array to later normalize characters
         */
        char char_max = characters[0];
        char_min = characters[0];
        for (char c: characters){
            if (c > char_max)
                char_max = c;
            if (c < char_min)
                char_min = c;
        }
        char_diff = char_max - char_min;

        /*
         * Define bar width
         * This can leave us with some leftover pixels if the division has reminder>0
         * To make it look better we rescale the picture and cut off the empty pixels
         */
        bar_width = dim/characters.length;
        dim -= dim % characters.length;

        /*
         * Set up the Image Window
         */
        w = new ImageWindow(dim,dim);
        w.openWindow();

        /*
         * Draw the initial array, then start sorting
         */
        drawArray(characters, w);
        sort(characters);

        /*
         * Final output
         */
        displayArray(characters);
    }
}
