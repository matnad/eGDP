package uebungen.blatt6;

import java.util.Random;
import java.util.StringJoiner;

/**
 * Class representing a simple model for a genom.
 *
 * A genom consists of a linear sequence of amino acid represented
 * as characters. The characters used are 'A', 'C', 'G' and 'T'.
 *
 */
public class Genom {

    // DONE define members
    private final char[] genom;
    private final char[] AMINOS = {'A','C','G','T'};

    /**
     * Constructs a genom of length len.
     *
     * @param len The length of the sequence.
     */
    Genom(int len) {
        // DONE implement this ...
        genom = new char[len];
        randomize();
    }

    /**
     * Returns the current genom as char-array.
     *
     * @return The current state of the genom as char array.
     */
    public char[] getGenom() {
        return genom;
    }

    /**
     * Returns the sequence as a String.
     */
    public String toString() {
        // DONE implement this ...
        StringJoiner sj = new StringJoiner(",", "<", ">");
        for (char g: genom) {
            sj.add(Character.toString(g));
        }
        return sj.toString();
    }

    /**
     * @param other Genom to compare with.
     * @return Returns true only if the two genoms have the same length and a fully identical sequence.
     */
    public boolean isEqual(Genom other) {
        // DONE implement this ...
        if (genom.length != other.genom.length)
            return false;

        for (int i = 0; i < genom.length; i++) {
            if (genom[i] != other.genom[i])
                return false;
        }

        return true;
    }

    /**
     * Fill the sequence with a random pattern.
     */
    private void randomize() {
        // DONE implement this ...
        Random rnd = new Random();
        for (int i = 0; i < genom.length; i++) {
            genom[i] = AMINOS[rnd.nextInt(AMINOS.length)];
        }
    }

    /**
     * Translates the number 0-3 into the amio acid characters A, C, G, T.
     *
     * @param c Integer representing amino acid.
     * @return Character for amino acid.
     */
    private char getChar(int c) {
        // DONE implement this ...
        return AMINOS[c];
    }

    /**
     * Sets a random amino acid at a random position.
     */
    public void pointMutation() {
        // DONE implement this ...
        genom[new Random().nextInt(genom.length)] = AMINOS[new Random().nextInt(AMINOS.length)];
    }

    /**
     * Insert a random amino acid at a random position.
     * This could also be before the first amino acid or after the last one.
     */
    public void insertion() {
        // DONE implement this ...
        char[] newGenom = new char[genom.length+1];
        int pos = new Random().nextInt(newGenom.length);
        System.arraycopy(genom, 0, newGenom, 0, pos); // arraycopy is faster than manual for loop copy
        newGenom[pos] = AMINOS[new Random().nextInt(AMINOS.length)];
        System.arraycopy(genom, pos, newGenom, pos + 1, newGenom.length - (pos + 1));
    }

    /**
     * Removes a random amino acid.
     */
    public void deletion() {
        // DONE implement this ...
        char[] newGenom = new char[genom.length-1];
        int pos = new Random().nextInt(newGenom.length);
        System.arraycopy(genom, 0, newGenom, 0, pos);
        System.arraycopy(genom, pos + 1, newGenom, pos, newGenom.length - pos);
    }

}

