package uebungen.blatt11;

import java.io.*;
import java.util.Arrays;

public class FussballResultate extends Thread {
    String[] resultate = new String[20];
    private final BufferedReader in;
    private boolean finished = false;

    FussballResultate(InputStream inStream) {
        in = new BufferedReader(new InputStreamReader(inStream));
        Arrays.fill(resultate, "");
    }

    public void run() {
        String currentLine;
        try {
            int i = 0;
            while ((currentLine = in.readLine()) != null) {
                resultate[i] = currentLine;
                i++;
            }
        } catch (IOException | NullPointerException e1) {
            System.out.println("Fehler beim lesen der Datei.");
            e1.printStackTrace();
        }
        finished = true;
    }

    public boolean isFinished(){
        return finished;
    }

    public String[] getResults() {
        return resultate;
    }


}