package uebungenMoritz.Blatt5;

import java.util.Arrays;

class PriorityQueue {
    static final int SIZE = 32;
    Element[] q = new Element[SIZE];
    int len;
    int tail = -1;

    // Insert an element into the queue according to its priority
    boolean put(Element x) {

        // if not full
        if (tail != 31) {

            // first input
            if (tail == -1) {
                q[0] = x;
                tail++;
                return true;
            }

            // if not first input
            if (tail >= 0) {

                // goes trough whole array
                for (int y = 0; y <= tail; y++) {

                    // cheking if x is bigger than the one at pos y
                    if (q[y].getPriority() < x.getPriority()) {
                        for (int v = tail; v >= y; v--) {
                            q[v + 1] = q[v];
                        }
                        q[y] = x;
                        tail++;
                        return true;
                    }

                    // if x is same size
                    if (q[y].getPriority() == x.getPriority()) {

                        // cheking all behind y/who is now c if equal
                        for (int c = y; c <= tail; c++) {
                            if (x.getPriority() > q[c].getPriority()) {

                                // sendig all after y one to the end
                                for (int v = tail; v >= c; v--) {
                                    q[v + 1] = q[v];
                                }
                                q[c] = x;
                                tail++;
                                return true;
                            }
                        }
                    }
                }
                q[tail + 1] = x;
                tail++;
                return true;
            }
        }

        // if full
        if (tail == 31) {

            // goes trough whole array
            for (int y = 0; y <= tail; y++) {

                // cheking if x is bigger in size
                if (q[y].getPriority() < x.getPriority()) {

                    // sendig all after y one to the end
                    for (int v = tail - 1; v >= y; v--) {
                        q[v + 1] = q[v];
                    }
                    q[y] = x;
                    return true;
                }
                // checking all behind y
                if (q[y].getPriority() == x.getPriority()) {
                    for (int c = y; c <= tail; c++) {
                        if (x.getPriority() > q[c].getPriority()) {

                            // sendig all after y one to the end
                            for (int v = tail - 1; v >= c; v--) {
                                q[v + 1] = q[v];
                            }
                            q[c] = x;
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    // Return the element with the highest priority from the queue
    Element get() {
        return q[0];

    }

    // Return the queue length
    int length() {
        return tail;
    }

    // Print the queue contents
    public String toString1() {
        return Arrays.toString(q);

    }

}