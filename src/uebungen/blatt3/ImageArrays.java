package uebungen.blatt3;

import ch.unibas.informatik.cs101.ImageWindow;

public class ImageArrays {

    static final int dim = 500; // all code is only for square image
    static final int dimsq = dim*dim;
    static final int img_len = dimsq*3;

	public static void main(String[] args) {
		//create & open the first window (to display the source image)


		ImageWindow sourceWindow= new ImageWindow(dim,dim);
		sourceWindow.openWindow("source",0,0);

		//load the image 
		sourceWindow.loadImage("resources/horn.jpg");

		//redraw to see the image
		sourceWindow.redraw();


		/*  TODO: create an array that is large enough to hold
		 *       the complete image information
		 */

        int[] img_arr = new int[img_len];


		/*  TODO: store the complete image information in the
         *        array you have created.
         *        HINT: int red=sourceWindow.getPixelRed(xPosition, yPosition);
		 *        int green=sourceWindow.getPixelGreen(xPosition, yPosition);
		 *        int blue=sourceWindow.getPixelBlue(xPosition, yPosition);
	 	 */

		// method 1
		for(int y=0; y<dim; y++){
            for(int x=0; x<dim; x++){
                int pos = y*dim+x;
                img_arr[pos] = sourceWindow.getPixelRed(x, y);
                pos += dimsq;
                img_arr[pos] = sourceWindow.getPixelGreen(x, y);
                pos += dimsq;
                img_arr[pos] = sourceWindow.getPixelBlue(x, y);
            }
        }


		//create & open the second window (to draw your copy into)
		ImageWindow destinationWindow= new ImageWindow(dim,dim);
		destinationWindow.openWindow("Image rotated by 90 degree",550,0);



		/*  TODO: write back your array data into the destinationWindow so that
                 *        it appears to be rotated 90 degrees.
                 *  HINT: destinationWindow.setPixel(xPos,yPos,red,green,blue);
		 */

                for(int y=0; y<dim; y++){
                    for(int x=0; x<dim; x++){
                        // get 1-D position
                        int pos = dim*y+x;

                        // get colors for current pixel
                        int red = img_arr[pos];
                        int green = img_arr[pos+dimsq];
                        int blue = img_arr[pos+dimsq+dimsq];

                        // calculate new position for pixel after rotation
                        int new_y_pos = x;
                        int new_x_pos =  dim-1-y;

                        // insert pixel at new position
                        destinationWindow.setPixel(new_x_pos,new_y_pos,red,green,blue);

                    }
                }



                // redraw to see the changed image
                destinationWindow.redraw();

                // Create another output window
		ImageWindow destinationWindow2= new ImageWindow(500,500);
		destinationWindow2.openWindow("Image with permuted color channels",0,550);



                /*  TODO: call here your function which permutes the color channels
                 */

                permute_colors(img_arr, destinationWindow2);

                // redraw to see the changed image
		destinationWindow2.redraw();
	}


        /*  TODO: implement here the function to rotate the color channels.
         *  HINT: think about the arguments you need for the function.
         */

    static void permute_colors(int[] img_arr, ImageWindow destinationWindow){

        // generate new array and apply all the mutations
        int[] new_img_arr = new int[img_len];

        for(int y=0; y<dim; y++){
            for(int x=0; x<dim; x++){

                // RED: mirror horizontally
                int pos = dim*y+x;
                int new_pos = y*dim + dim-1-x;
                new_img_arr[new_pos] = img_arr[pos];

                // GREEN: mirror vertically
                pos += dimsq;
                new_pos = dimsq + (dim-1-y)*dim + x;
                new_img_arr[new_pos] = img_arr[pos];

                // BLUE: mirror diagonally
                pos += dimsq;
                new_pos = dimsq + dimsq + dim*x + y;
                new_img_arr[new_pos] = img_arr[pos];
            }
        }

        // write new array to the destionationWindow
        for(int y=0; y<dim; y++){
            for(int x=0; x<dim; x++) {
                // get 1-D position
                int pos = dim*y+x;

                // retrieve colors for current pixel
                int red = new_img_arr[pos];
                int green = new_img_arr[pos + dimsq];
                int blue = new_img_arr[pos + dimsq + dimsq];

                // set pixel in destionationWindow
                destinationWindow.setPixel(x, y, red, green, blue);
            }
        }
    }



}
