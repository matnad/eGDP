package uebungen.blatt5;

public class Element {
    private int priority;
    private String data;

    public String getData() {
        return data;
    }
    public int getPriority() {
        return priority;
    }

    public Element(int priority, String data) {
        this.priority = priority;
        this.data = data;
    }

    public String toString()        {
        String output = String.format("Element with priority %d and data: %s", priority, data);
        return output;
    }
}

