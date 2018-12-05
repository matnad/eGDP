package uebungen.blatt11.bildbearbeitung;

import ch.unibas.informatik.cs101.ImageWindow;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicImageProcessing {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private static File image = null;
    private static String folder = "resources/images";
    private static FaltungsKern kern = null;
    private static ImageWindow iw = null;

    public static void main (String[] args) {
        //TODO

        if (args.length == 1)
            folder = args[0];

        printCommandMsg();

        while (true) {
            String read = "";
            try {
                read = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            switch (read) {
                case "open":
                    System.out.println("Choose image");
                    open();
                    break;
                case "filter":
                    System.out.println("Choose filter");
                    selectKern();
                    break;
                case "apply":
                    applyFilter();
                    break;
                case "q": case "Q": case "quit": case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid command.");
                    printCommandMsg();
                    break;
            }
        }

        /*ImageWindow iw2 = new ImageWindow(500, 500);
        iw2.loadImage("resources/horn.jpg");
        iw2.openWindow();

        FaltungsKern kern = new FaltungsKern("kern1.txt");

        ImageWindow iw = new ImageWindow(500, 500);
        iw.loadImage("resources/horn.jpg");
        kern.falten(iw);
        iw.openWindow();

        kern = new FaltungsKern("kern2.txt");

        ImageWindow iw3 = new ImageWindow(500, 500);
        iw3.loadImage("resources/horn.jpg");
        kern.falten(iw3);
        iw3.openWindow();*/

    }

    private static void applyFilter() {
        if(kern != null && image != null && iw != null && kern.isLoaded()) {
            kern.falten(iw);
            iw.redraw();
            System.out.println("Filter applies successfully.");
        } else {
            System.out.println("<open> an image and load a <filter> before using the <apply> command.");
        }
    }

    private static void printCommandMsg() {
        System.out.println("Commands: \n<open> to load a new image. \n<filter> to load a new filter core. \n<apply> to apply the current filter to the current image.");
    }

    private static void selectKern() {
        List<File> filesInFolder = null;

        try {
            filesInFolder = Files.walk(Paths.get("resources/kerne/"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert filesInFolder != null;
        for (int i = 0; i < filesInFolder.size(); i++) {
            System.out.println(i+1+": "+filesInFolder.get(i).getName().replaceFirst("[.][^.]+$", ""));
        }

        String choice = getInput("Type the number of the filter to load");
        int choiceInt = 0;
        try {
            choiceInt = Integer.parseInt(choice);
        } catch (Exception e) {
            System.out.println("Command is not a number.");
        }

        if (choiceInt > filesInFolder.size() || choiceInt <= 0) {
            System.out.println(String.format("Filter with number %d not found.", choiceInt));
        } else {
            File kernFile = filesInFolder.get(choiceInt-1);
            try {
                kern = new FaltungsKern(kernFile.getName());
                System.out.println(String.format("Filter \"%s\" loaded.", kernFile.getName().replaceFirst("[.][^.]+$", "")));
            } catch (IOException e) {
                System.out.println(String.format("Filter %s could not be loaded, invalid file.", kernFile.getName().replaceFirst("[.][^.]+$", "")));
            }
        }

    }

    private static void open() {
        List<File> filesInFolder = null;

        try {
            filesInFolder = Files.walk(Paths.get(folder))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert filesInFolder != null;
        for (int i = 0; i < filesInFolder.size(); i++) {
            System.out.println(i+1+": "+filesInFolder.get(i).getName());
        }
        String choice = getInput("Type the number of the image to open");
        int choiceInt = 0;
        try {
            choiceInt = Integer.parseInt(choice);
        } catch (Exception e) {
            System.out.println("Command is not a number.");
        }

        if (choiceInt > filesInFolder.size() || choiceInt <= 0) {
            System.out.println(String.format("File with number %d not found.", choiceInt));
        } else {
            image = filesInFolder.get(choiceInt-1);
            try {
                Image img = ImageIO.read(image);
                if (img == null) {
                    System.out.println(String.format("The file %s could not be opened , it is not an image!", image.getName()));
                    image = null;
                } else {

                    BufferedImage bimg = ImageIO.read(image);
                    int width          = bimg.getWidth();
                    int height         = bimg.getHeight();
                    iw = new ImageWindow(width, height);
                    iw.loadImage(image.getPath());
                    iw.openWindow();

                    System.out.println(String.format("File opened: %s", image.getName()));
                }
            } catch(IOException ex) {
                System.out.println("The file %s could not be opened, an error occurred.");
            }
        }
    }

    private static String getInput(String message){
        System.out.println(message);
        String read = "";
        try {
            read = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return read;
    }

}
