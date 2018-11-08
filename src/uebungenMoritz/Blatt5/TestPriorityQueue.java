package uebungenMoritz.Blatt5;

class Sort {
    public static void main(String[] args) {
        PriorityQueue a = new PriorityQueue();
        Element E4 = new Element(4,"test4");
        Element E3 = new Element(3,"test3");
        Element E2a = new Element(2,"test2a");
        Element E2b = new Element(2,"test2b");
        Element E2c = new Element(2,"test2c");
        Element E1 = new Element(1,"test1");
        Element E5 = new Element(10,"test10");



        a.put(E4);
        a.put(E3);
        a.put(E2a);
        a.put(E5);
        a.put(E2b);
        a.put(E1);
        a.put(E2c);
        a.put(E2c);
        a.put(E2c);
        a.put(E2c);
        a.put(E2c);
        a.put(E5);
        a.put(E5);
        a.put(E5);
        a.put(E2c);
        a.put(E2c);
        a.put(E2c);
        a.put(E2c);
        a.put(E2c);
        a.put(E2c);
        a.put(E2c);
        a.put(E2c);
        a.put(E1);
        a.put(E4);
        a.put(E5);
        System.out.println(a.toString1());
    }
}
