package uebungen.blatt5;

public class TestPriorityQueue {

    public static void main(String[] args){
        System.out.println("Generating new Element");
        Element e1 = new Element(1, "test");
        System.out.println(e1);

        System.out.println("Get Priority: " + e1.getPriority());
        System.out.println("Get Data: " + e1.getData());

        System.out.println();
        System.out.println("Generating new Priority Queue.");
        PriorityQueue PQ = new PriorityQueue();
        System.out.println(PQ);

        System.out.println();
        System.out.println("Adding Element 1 to PQ.");
        PQ.put(e1);
        System.out.println(PQ);

        System.out.println();
        System.out.println("Get first Element.");
        System.out.println(PQ.get());
        System.out.println(PQ);

        System.out.println();
        System.out.println("Add lots of elements.");
        int[] prios = {10, 20, 50, 20, 11, 22, 20, -55, 90, 1, 22, 65};
        for (int p : prios) {
            PQ.put(new Element(p, "ElementData"));
        }
        System.out.println("New Length: " + PQ.length());
        System.out.println(PQ);

        System.out.println();
        System.out.println("Add another P20 Element.");
        PQ.put(new Element(20, "New Element"));
        System.out.println(PQ);

        System.out.println();
        System.out.println("Try to overload queue.");
        for (int i=19; i <= 40; i++){
            Element e = new Element(i, "OverloadData");
            boolean success = PQ.put(e);
            if (success) {
                System.out.println(String.format("%s has been successfully added to PQ. New Length: %d", e, PQ.length()));
            } else {
                System.out.println(String.format("ERROR while adding %s to PQ. New Length: %d", e, PQ.length()));
            }
        }

        System.out.println();
        System.out.println(PQ);

        System.out.println();
        System.out.println("Get the first element.");
        System.out.println(PQ.get());
        System.out.println(PQ);

//        System.out.println();
    }

}
