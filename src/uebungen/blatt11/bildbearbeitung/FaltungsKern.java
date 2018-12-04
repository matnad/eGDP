package uebungen.blatt11.bildbearbeitung;

import ch.unibas.informatik.cs101.ImageWindow;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.*;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FaltungsKern {

    float[][] kern;
    float norm;
    float gain;

    int kernW = 0;
    int kernH = 0;

    private boolean loaded = false;

    public FaltungsKern() throws IOException {
        //TODO erstelle einen Faltungskern mit standart Werten
        this("kern1.txt");
    }

    public FaltungsKern(String filename) throws IOException {
        //TODO erstelle Faltungskern aus dem File
        lade_kern(filename);
        if (kernW == 0 || kernH == 0)
            throw new IOException("Can't parse file.");
        else
            loaded = true;
    }

    public void falten(ImageWindow origIw) {
        //TODO wende den Faltungskern auf das Bild an

        // COPY
        int w = origIw.getImageWidth();
        int h = origIw.getImageHeight();
        ImageWindow iw = new ImageWindow(w,h);
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                Color color =  origIw.getPixel(i,j);
                iw.setPixel(i,j,color.getRed(), color.getGreen(), color.getBlue());
            }
        }

        // FALTEN
        int kernHalfW = kernW/2;
        int kernHalfH = kernH/2;
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                float summe[] = {gain, gain, gain};
                for (int k = -kernHalfW; k <= kernHalfW; k++) {
                    for (int l = -kernHalfH; l <= kernHalfH; l++) {
                        int x = i + k;
                        if (x < 0)
                            x = 0;
                        else if (x > w)
                            x = w;

                        int y = j + l;
                        if (y < 0)
                            y = 0;
                        else if (y > h)
                            y = h;

                        summe[0] += iw.getPixelRed(x,y) * kern[k+kernHalfW][l+kernHalfH];
                        summe[1] += iw.getPixelGreen(x,y) * kern[k+kernHalfW][l+kernHalfH];
                        summe[2] += iw.getPixelBlue(x,y) * kern[k+kernHalfW][l+kernHalfH];

                    }
                }
                iw.setPixel(i, j, (int) Math.max(0,Math.min(255,summe[0])), (int) Math.max(0,Math.min(255,summe[1])), (int) Math.max(0,Math.min(255,summe[2])));
            }
        }

        // COPY
        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                Color color =  iw.getPixel(i,j);
                origIw.setPixel(i,j,color.getRed(), color.getGreen(), color.getBlue());
            }
        }

    }

    public void lade_kern(String filename) {
        //TODO lies die Daten aus dem File

        String file = "resources/kerne/"+filename;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            System.out.println(String.format("Datei \"%s\" konnte nicht gefunden werden! Bitte Pfad kontrollieren.", file));
            System.exit(-1);
        }

        String currentLine;
        try {
            while ((currentLine = br.readLine()) != null) {
                String[] lineSplit = currentLine.split(" ");
                if( lineSplit.length < 2)
                    continue;
                if (lineSplit[0].equals("size") && lineSplit.length == 3) {
                    kernW = Integer.parseInt(lineSplit[1]);
                    kernH = Integer.parseInt(lineSplit[2]);
                    kern = new float[kernW][kernH];
                } else if (lineSplit[0].equals("norm") && lineSplit.length == 3) {
                    norm = Float.parseFloat(lineSplit[1]) / Float.parseFloat(lineSplit[2]);
                } else if (lineSplit[0].equals("gain") && lineSplit.length == 2) {
                    gain = Integer.parseInt(lineSplit[1]);
                } else if (lineSplit[0].equals("data") && lineSplit.length-1 == kernW*kernH) {
                    if (norm == 0)
                        break;
                    for (int i = 0; i < kernW; i++) {
                        for (int j = 0; j < kernH; j++) {
                            float zahl = Float.parseFloat(lineSplit[i*kernW+j+1]);
                            kern[i][j] = zahl * norm;
                        }
                    }
                }
            }
        } catch (IOException | NullPointerException e1) {
            System.out.println("Fehler beim lesen der Datei.");
            e1.printStackTrace();
        }

    }

    public void falten_grau(ImageWindow iw) {
        //OPTIONAL
        // berechne den Grauwert als (Rot+Grün+Blau)/3
        // Falte das Bild nur einmal pro (x/y) Stelle
        // schreibe in jeden Farbkanal diesen Wert
    }

    public static void median(ImageWindow iw) {
        //OPTIONAL
        // lies alle Werte aus dem Bild im Bereich des Faltungskerns
        // speichere die Werte in einer Liste
        // setze das Zielbild auf den Wert welcher in der Liste in der Mitte steht
    }

    public boolean isLoaded() {
        return loaded;
    }
}
