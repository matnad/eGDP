package uebungen.blatt5;

public class PriorityQueue {
    static final int SIZE = 32;
    final Element[] q = new Element[SIZE];
    int len = 0;

    /**
     * Insert an element into the Priority Queue according to its priority.
     * Same priority gets inserted according to FIFO.
     * @param x element to insert
     * @return true if insertion was successful, false otherwise.
     */
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
                System.arraycopy(q, i, q, i+1, len-i); //  faster & better than manual array copy
                q[i] = x;
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
    /**
     * Return the element with the highest priority from the queue and remove that element from the queue.
     * @return element with highest priority
     */
    Element get() {
        if (len <= 0) {
            System.out.println("PriorityQueue is empty. Returning an empty object with priority 1.");
            return new Element(1,"");
        }

        Element return_element = q[0];
        try {
            System.arraycopy(q, 1, q, 0, len-1); // faster & better than manual array copy
        } catch (Exception e) {
            System.out.println("Error while trying to get the highest Element in the PriorityQueue.");
            throw new java.lang.Error(e);
        }

        len--;
        return return_element;
    }

    /**
     * Return the queue length
     * @return queue length
     */
    int length() {
        return len;
    }

    /**
     * Return human readable string with description and contents of the Priority Queue
      * @return string with description of queue and contents
     */
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (len > 0) {
            output.append(String.format("Priority queue has %d entries. The highest priority is %d.", len, q[0].getPriority()));
            output.append("\nThe following elements are in the Priority Queue in this order: ");
            for (int i = 0; i < len; i++) {
                output.append("\n").append(i + 1).append(") ").append(q[i].toString());
            }
        } else {
            output.append("This Priority Queue is empty.");
        }

        return output.toString();
    }
}

