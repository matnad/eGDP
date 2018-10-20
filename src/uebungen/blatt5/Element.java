package uebungen.blatt5;

public class Element {
    private int priority;
    private String data;

    /**
     * Return data as string.
     * @return data as string.
     */
    public String getData() {
        return data;
    }

    /**
     * Return the priority as int.
     * @return priority as int.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Generator for new elements.
     * @param priority defines the priority for the new element. Can be negative or zero.
     * @param data defines the data of the new element as a String.
     */
    public Element(int priority, String data) {
        this.priority = priority;
        this.data = data;
    }

    /**
     * Returns a String that describes the element and is ready to print.
     * @return String with priority and data in human readable format.
     */
    public String toString()        {
        return String.format("Element with priority %d and data: %s", priority, data);
    }
}

