package uebungenMoritz.Blatt5;

class Element {

    private int priority;
    private String data;

    public Element(int priority, String data) {
        this.priority = priority;
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public int getPriority() {
        return this.priority;
    }

    public String toString() {
        return (this.priority + "," + this.data);
    }

}
