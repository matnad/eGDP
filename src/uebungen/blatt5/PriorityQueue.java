package uebungen.blatt5;

public class PriorityQueue {
    static final int SIZE = 32;
    Element[] q = new Element[SIZE];
    int len = 0;

    // Insert an element into the queue according to its priority
    boolean put(Element x) {
        if (len >= SIZE) {
            System.out.println("PriorityQueue is full.");
            return false;
        }

        /*
         * Insert before the first smaller element
         */
        for (int i=0; i<len; i++) {
            if (x.getPriority() > q[i].getPriority()){
                try {
                    for (int j = len; j > i; j--) {
                        q[j] = q[j-1];
                    }
                    q[i] = x;
                } catch (Exception e) {
                    System.out.println("Error while trying to insert a new element into the PriorityQueue.");

                    throw new java.lang.Error(e);
                }

                len++;
                return true;
            }
        }

        /*
         * If PriorityQueue is empty or the value is smaller than all the others, insert at the "end".
         */
        q[len] = x;
        len++;
        return true;
    }

    // Return the element with the highest priority from the queue
    Element get() {
        if (len <= 0) {
            System.out.println("PriorityQueue is empty. Returning an empty object with priority 1.");
            return new Element(1,"");
        }

        Element return_element = q[0];
        try {
            for (int i = 0; i < len - 1; i++) {
                q[i] = q[i + 1];
            }
        } catch (Exception e) {
            System.out.println("Error while trying to get the highest Element in the PriorityQueue.");
            throw new java.lang.Error(e);
        }

        len--;
        return return_element;
    }

    // Return the queue length
    int length() {
        return len;
    }

    // Print the queue contents
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (len > 0) {
            output.append(String.format("Priority queue has %d entries. The highest priority is %d.", len, q[0].getPriority()));
            output.append("\nThe following elements are in the Priority Queue in this order: ");
            for (int i = 0; i < len; i++) {
                output.append("\n"+(i+1)+") " + q[i].toString());
            }
        } else {
            output.append("This Priority Queue is empty.");
        }

        return output.toString();
    }
}

