package uebungen.blatt10;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class Post {

    private final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private Map<Integer, String> entries = new HashMap<>();


    Post() {
        loadFile("resources/Adressdaten.csv");
    }

    void loadFileStream(String path) {
        Stream<String> csv = null;
        try {
            csv = Files.lines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (csv != null) {
            entries = csv.map(x -> x.split(";")).filter(x -> x.length > 6).collect(Collectors.toMap(x -> Integer.parseInt("1"), x -> "ok"));
            csv.close();
        }
    }

    void loadFile(String path){

        BufferedReader br = null;
        try {
            //br = new BufferedReader(new FileReader(path));
            br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "ISO-8859-1"));
        } catch (FileNotFoundException e) {
            System.out.println(String.format("Datei \"%s\" konnte nicht gefunden werden! Bitte Pfad kontrollieren.", path));
            System.exit(-1);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        String currentLine;
        try {
            while ((currentLine = br.readLine()) != null) {
                parseLine(currentLine);
            }
        } catch (IOException | NullPointerException e1) {
            System.out.println("Fehler beim lesen der Datei. Eventuell wurde nicht die ganze Datei eingelesen.");
            e1.printStackTrace();
        }
    }

    private void parseLine(String currentLine) {

        String[] larr = currentLine.split(";");

        if (larr.length < 7) {
            System.out.println("Eintrag inkorrekt formatiert. Überspringe diesen Eintrag.");
            return;
        }

        int plz;
        String ort = larr[8];

        try {
            plz = Integer.parseInt(larr[4]);
        } catch (NumberFormatException e) {
            System.out.println(String.format("Postleitzahl \"%s\" konnte nicht gelesen werden, da das Format ungültig ist. Überspringe diesen Eintrag.", larr[4]));
            return;
        }
        entries.putIfAbsent(plz, ort);
    }

    void run() {
        String read;
        while(true) {
            System.out.println(System.lineSeparator()+"Bitte Postleitzahl eingeben:");
            try {
                read = in.readLine();
            } catch (IOException e) {
                System.out.println("Fehler beim lesen des Befehls.");
                e.printStackTrace();
                continue;
            }

            if (read.equals("q") || read.equals("Q"))
                System.exit(0);

            int plz;
            try {
                plz = Integer.parseInt(read);
            } catch (NumberFormatException e) {
                System.out.println(String.format("Die Eingabe \"%s\" is keine Zahl. Es wurde eine Postleitzahl als Eingabe erwartet.", read));
                continue;
            }

            String ort = entries.get(plz);

            if (ort == null) {
                System.out.println(String.format("Es wurde kein Ort mit der PLZ %d gefunden.", plz));
            } else {
                System.out.println(ort);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Post post = new Post();
        post.run();
    }
}
