package uebungen.blatt6;

import java.util.Random;
import java.util.StringJoiner;

/**
 * A simple GenPool.
 *
 * The genpool holds multiple genoms. It has a method to check if
 * a specific genom exists and offers a function to mutate all genoms
 * once.
 */
class GenPool {

    // DONE define members
    private final Genom[] genoms;

    /**
     * Generate n genoms with a random length in the interval 1 - len.
     *
     * @param n Number of genoms in the genpool.
     * @param len Maximal length of a genom when initializing. (Minimal length is 1.)
     */
    GenPool( int n, int len ) {
        // DONE implement this ...
        genoms = new Genom[n];
        randomize(len);
    }


    /**
     * Returns all the genoms from the genpool as array.
     *
     * @return Array containing all genoms currently in this pool.
     */
    public Genom[] getGenPool() {
        return genoms;
    }

    /**
     * Randomly fills the genpool.
     *
     * @param len Maximal length of a genom when initializing. (Minimal length is 1.)
     */
    private void randomize(int len) {
        // DONE implement this ...
        Random rnd = new Random();
        for (int i = 0; i < genoms.length; i++) {
            genoms[i] = new Genom(rnd.nextInt(len)+1);
        }
    }

    /**
     * Checks if a specific genom exists in the genpool.
     * @param other Genom to search for.
     * @return Returns true if the genom other is found in the genpool.
     */
    public boolean contains(Genom other) {
        for (Genom g :
                genoms) {
            if(g.isEqual(other))
                return true;
        }
        return false;
    }

    /**
     * Performs one mutation for every genom in the pool.
     */
    public void mutate() {
        // implement this ...
        Random rnd = new Random();
        for (Genom g :
                genoms) {
            switch (rnd.nextInt(2)){
                case 0: g.pointMutation(); break;
                case 1: g.insertion(); break;
                case 2: g.deletion(); break;
            }

        }
    }

    /**
     * Returns all gens from the pool on a single line.
     */
    public String toString() {
        // implement this ...
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        for (Genom g :
                genoms) {
            sj.add(g.toString());
        }
        return sj.toString();
    }

}

